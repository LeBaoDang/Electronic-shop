const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function($scope, $http) {
	/* quản lí giỏ hàng */
	$scope.cart = {
		items: [],
		// thêm sản phẩm vào giỏ hàng
		add(id) {
			// kiểm tra item
			var item = this.items.find(item => item.id == id);
			// xét có item nào như trên đã tồn tại nếu có tăng số lương
			if (item) {
				item.qty++;
				this.saveToLocalStorage();
			} else { // nếu không có gọi api thêm vào
				$http.get(`/rest/products/${id}`).then(resp => {
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();
				})
			}
		},
		// xóa sản phẩn khỏi giỏ hàng
		remove(id) {
			// tìm vị trí sp khi truyền id vào
			var index = this.items.findIndex(item => item.id == id);
			//xóa
			this.items.splice(index, 1);
			// lưu lại
			this.saveToLocalStorage();
		},
		//xóa sạch các mặt hàng trong giỏ
		clear() {
			// cho mảng là rỗng
			this.items = []
			// sao đó lưu lại
			this.saveToLocalStorage();
		},
		// tính thành tiền của một sản phẩm
		amt_of(item) { },
		// tính tổng số lượng mặt hàng có trong giỏ
		get count() {
			return this.items
				.map(item => item.qty)
				.reduce((total, qty) => total += qty, 0);
		},
		// tổng thành tiền các mặt hàng có trong giỏ
		get amount() {
			return this.items
				.map(item => item.qty * item.price)
				.reduce((total, qty) => total += qty, 0);
		},
		// lưu giỏ hàng vào trong local storage
		saveToLocalStorage() {
			// đổi các mặt hàng sang json
			var json = JSON.stringify(angular.copy(this.items));
			//dùng json lưu vào local với tên là cart
			localStorage.setItem("cart", json);
		},
		//Đọc giỏ hàng từ local storage
		loadFromLocalStorage() {
			// đọc lại json trong local ra
			var json = localStorage.getItem("cart");
			// nếu có chuyển lại json và gán vào items ko gán mảng rỗng
			this.items = json ? JSON.parse(json) : [];
		}

	}
	// khi ứng dụng bắt đầu tải lại toàn bộ mặt hàng local của mình vào
	// trong cart của mình
	$scope.cart.loadFromLocalStorage();

	$scope.order = {
		createDate: new Date(),
		address: "",
		account: { username: $("#username").text() },
		// tạo ra orderDetail lấy toàn bộ mặt hàng có trong giỏ hàng
		get orderDetails() {
			return $scope.cart.items.map(item => {
				return {
					product: { id: item.id },
					price: item.price,
					quantity: item.qty
				}
			});
		},
		// gửi thông tin lên server
		purchase() {
			var order = angular.copy(this);
			// thực hiện đặt hàng
			$http.post("/rest/orders", order).then(resp => {
				alert("Đặt hàng thành công!");
				$scope.cart.clear();
				location.href = "/order/detail/" + resp.data.id;
			}).catch(error => {
				alert("Đặt hàng lỗi!")
				console.log(error)
			})
		}
	}
	
}
)
