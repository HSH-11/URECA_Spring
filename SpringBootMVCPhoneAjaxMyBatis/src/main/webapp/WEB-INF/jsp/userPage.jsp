<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

<script
	src="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/alertify.min.js"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/alertify.min.css" />
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/themes/bootstrap.min.css" />
<title>휴대폰 목록</title>
</head>
<body>
	<div class="container mt-5">
		<h2 class="mb-4 text-center">📱 휴대폰 목록</h2>

		<!-- 검색 기능 -->
		<div class="input-group mb-3">
			<input type="text" class="form-control" id="inputSearchWord"
				placeholder="상품명을 입력하세요">
			<button class="btn btn-outline-secondary" type="button"
				id="btnSearchWord">검색</button>
		</div>

		<!-- 상품 목록 -->
		<table
			class="table table-bordered table-hover text-center align-middle">
			<thead class="table-light">
				<tr>
					<th>상품 ID</th>
					<th>상품명</th>
					<th>가격</th>
					<th>재고</th>
					<th>주문</th>
				</tr>
			</thead>
			<tbody id="productTBody">

			</tbody>
		</table>
		<nav>
			<ul id="pagination" class="pagination justify-content-center"></ul>
		</nav>

	</div>

	<!-- 주문 모달 -->
	<div class="modal fade" id="orderModal" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="orderForm">
					<div class="modal-header">
						<h5 class="modal-title">📦 상품 주문</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>
					<div class="modal-body">
						<input type="hidden" id="orderProductId">

						<div class="mb-3">
							<label class="form-label">상품명</label> <input type="text"
								class="form-control" id="orderProductName" readonly>
						</div>
						<div class="mb-3">
							<label class="form-label">수량</label> <input type="number"
								class="form-control" id="orderQuantity" value="1" min="1">
						</div>
						<div class="mb-3">
							<label class="form-label">배송지</label> <input type="text"
								class="form-control" id="orderAddress">
						</div>
						<div class="mb-3">
							<label class="form-label">총 가격</label> <input type="text"
								class="form-control" id="orderTotal" readonly>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">주문하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script src="/js/userProduct.js"></script>

</body>
</html>
