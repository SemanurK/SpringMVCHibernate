<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<title>Talep Düzenle</title>
</head>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #6c757d;
}

.topnav a {
	float: left;
	color: #fff;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #5cb85c;
	color: white;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}
</style>
<body>

	<div class="topnav">

		<a href="<%=request.getContextPath()%>/Talep/yenitalep">Talep Ekle</a>
		<a href="<%=request.getContextPath()%>/Talep/index">Talep Listesi</a>

	</div>
	<div class="container">
		<div class="row" style="margin-top: 80px;">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="card">
					<div class="card-header">
						<c:if test="${talepbilgi==null }">
							<h6>Talep Oluşturma İşlemi</h6>
						</c:if>
						<c:if test="${talepbilgi!=null }">
							<h6>Talep Düzenleme İşlemi</h6>
						</c:if>

					</div>
					<div class="card-body">
						<form:form action="guncelle" method="post"
							modelAttribute="talepbilgi">

							<div class="row">
								<form:hidden path="id" />
								<div class="col-sm-4">
									<form:label path="talep_id"
										style="float: right; margin-top: 4px;"> Talep ID
										:</form:label>
								</div>

								<div class="col-sm-2">
									<form:input type="number" class="form-control"
										style="float: left;" required="required" min="1"
										path="talep_id" />
								</div>
								<div class="col-sm-3">
									<form:label path="change_id"
										style="float: right; margin-top: 4px;"> Change
										ID :</form:label>
								</div>
								<div class="col-sm-3">
									<form:input type="text" class="form-control"
										style="float: left;" id="change_id" name="change_id"
										onkeyup="javascript:Kontrol()" path="change_id" />
								</div>
							</div>

							<div class="row" style="margin-top: 8px;">
								<div class="col-sm-4">
									<form:label path="spring_no"
										style="float: right; margin-top: 4px;"> Spring
										Numarası :</form:label>
								</div>
								<div class="col-sm-8">
									<form:input type="number" class="form-control"
										style="float: left;" required="required" name="spring_no"
										min="1" path="spring_no" />
								</div>
							</div>
							<div class="row" style="margin-top: 8px;">
								<div class="col-sm-4">
									<form:label path="adi" style="float: right; margin-top: 4px;"> Talep
										Adı :</form:label>
								</div>
								<div class="col-sm-8">
									<form:input type="text" class="form-control"
										style="float: left;" required="required" name="adi" id="name"
										path="adi" />
								</div>
							</div>
							<div class="row" style="margin-top: 8px;">
								<div class="col-sm-4">
									<form:label path="efor" style="float: right; margin-top: 4px;"> Efor :</form:label>
								</div>
								<div class="col-sm-8">
									<form:input type="text" class="form-control"
										style="float: left;" required="required" name="efor"
										path="efor" />
								</div>
							</div>

							<div class="row" style="margin-top: 8px;">
								<div class="col-sm-4">
									<form:label path="talep_sahip"
										style="float: right; margin-top: 4px;"> Talebin
										Sahibi :</form:label>
								</div>
								<!-- 								<div class="col-sm-8"> -->
								<%-- 									<form:select path="talep_sahip" class="form-control" --%>
								<%-- 										items="${kullaniciBilgi}" itemValue="id" itemLabel="adSoyad"> --%>
								<%-- 									</form:select> --%>
								<!-- 								</div> -->
							</div>
							<div class="row" style="margin-top: 8px;">
								<div class="col-sm-4">
									<form:label path="tarih" style="float: right; margin-top: 4px;"> Talep
										Tarihi :</form:label>
								</div>
								<div class="col-sm-8">
									<%-- 								<fmt:formatDate value="${tarih}" pattern="yyyy-MM-dd" var="myDate" /> --%>
									<%-- <form:input path="tarih" id="tarih" value="${myDate}" /> --%>

									<form:input type="date" class="form-control" name="tarih"
										id="tarih" readonly="readonly" path="tarih" />
								</div>
							</div>
							<div class="row" style="margin-top: 8px;">
								<div class="col-sm-4">
									<form:label path="baslangic_tarihi"
										style="float: right; margin-top: 4px;">    
																	Başlangıç Tarihi :</form:label>

								</div>
								<div class="col-sm-8">
									<form:input type="date" class="form-control"
										name="baslangic_tarihi" id="baslangic_tarihi"
										path="baslangic_tarihi" />

								</div>
							</div>
							<div class="row" style="margin-top: 8px;">
								<div class="col-sm-4">
									<form:label path="bitis_tarihi"
										style="float: right; margin-top: 4px;"> Bitiş  
																	Tarihi :</form:label>

								</div>
								<div class="col-sm-8">
									<form:input type="date" class="form-control"
										name="bitis_tarihi" id="bitis_tarihi" path="bitis_tarihi" />
								</div>
							</div>

							<div class="row" style="margin-top: 10px;">
								<div class="col-sm-4">
									<form:label path="durum" style="float: right; margin-top: 4px;"> Durum :</form:label>
								</div>
								<div class="col-sm-8">
									<div class="btn-group">
										<c:if test="${talepbilgi==null }">
											<form:radiobutton path="durum" value="false"
												checked="checked" id="d_durum" style="margin-top: 10px;" />
											<form:label path="durum"
												style="margin-left: 8px; margin-top: 2px;">
																			Devam Ediyor </form:label>
											<form:radiobutton path="durum" value="true" id="t_durum"
												style="margin-top: 10px; margin-left: 40px;" />
											<form:label path="durum"
												style="margin-left: 8px; margin-top: 2px;">Tamamlandı</form:label>
										</c:if>
										<c:if test="${talepbilgi!=null }">
											<form:radiobutton path="durum" value="false" id="d_durum"
												style="margin-top: 10px;"
												checked="${durum== false ? 'checked' : '' }" />
											<form:label path="durum"
												style="margin-left: 8px; margin-top: 2px;">
																			Devam Ediyor </form:label>
											<form:radiobutton path="durum" value="true" id="t_durum"
												style="margin-top: 10px; margin-left: 40px;"
												checked="${durum== true ? 'checked' : '' }" />
											<form:label path="durum"
												style="margin-left: 8px; margin-top: 2px;">
																			Tamamlandı </form:label>
										</c:if>
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-sm-12">
									<c:if test="${talepbilgi==null }">

										<Button class="btn waves-effect waves-light btn-success"
											style="float: right;">Talep Oluştur</Button>

									</c:if>
									<c:if test="${ talepbilgi!=nul}">
										<Button class="btn waves-effect waves-light btn-success"
											style="float: right;">Talebi Güncelle</Button>
									</c:if>

								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-1"></div>
	</div>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<script type="text/javascript">
		function Kontrol() {

			var date = new Date();
			var dateOptions = {
				day : '2-digit',
				month : '2-digit',
				year : 'numeric'
			};
			var currentDate = date.toLocaleDateString('ja-JP', dateOptions)
					.replace(/\//gi, '-');
			var timeOptions = {
				hour : '2-digit',
				minute : '2-digit'
			};
			var currentTime = date.toLocaleTimeString('it-IT', timeOptions);

			if (document.getElementById('change_id').value.length != 0) {
				document.getElementById('tarih').value = currentDate;
				var x = document.getElementById('tarih').value;
				alert(x);

				document.getElementById('t_durum').checked = true;
			} else {
				document.getElementById('tarih').value = "";
				document.getElementById('d_durum').checked = true;

			}
		}

		$(document)
				.ready(
						function() {

							var sonuc = '${sonuc}';

							if (sonuc != null && sonuc != '') {

								if (sonuc == 0) {
									swal(
											"Hata!",
											"Aynı ID numarasına sahip talep sisteme eklenemez !",
											"warning");
								} else {
									swal(
											"Başarılı!",
											"Talep sisteme başarılı şekilde eklendi.",
											"success");
								}
							}

						});
	</script>
</body>
</html>