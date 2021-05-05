<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <link rel="stylesheet" href="../mystyle.css">
  <title>Provera JMBG</title>

  <!-- Font Awesome Icons -->

</head>
<body class="hold-transition sidebar-mini">

  <!-- Navbar -->
  
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Product Logo -->

    <!-- Sidebar -->
      <!-- Sidebar Menu -->

    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->


    <!-- Main content -->
    <section class="content">
      <div class="container-fluid" align="center">
        <div class="row">
          <div class="col-md-6">
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title" align="center">Provera JMBG</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form:form role="form" modelAttribute="broj" action="check">
                <div class="card-body" align="center">
                  <div class="form-group" align="center">
                    <label>JMBG</label>
                    <form:input path="jmbg" class="form-control" maxlength="13" id="text"/>
                    <form:errors path="jmbg" cssClass="text-danger"/>
                  </div>
                  
                </div>
                <!-- /.card-body -->
				<br>
                <div class="card-footer">
                  <button  type="submit" class="button button1">Proveri</button>
                </div>
              </form:form>
              
             <c:if test="${broj.jmbg.length()==null }"></c:if>
              
              
              <c:if test="${broj.isValid }">
              
              	 BROJ JE VALIDAN!
              	 <br>
              	 Datum rodjenja: ${broj.datum }
              	 <br>
              	 Okrug: ${broj.okrug }
              	 <br>
               <a href="home">Ponovi</a>
              </c:if>
              
              <c:if test="${!broj.isValid && broj.jmbg.length()==13}">
                 BROJ NIJE VALIDAN
                 <br>
                 <c:if test="${broj.isUnetoSlovo }">
              	UNESITE SAMO CIFRE
              <br>
              </c:if>
                 <a href="home">Ponovi</a>
              </c:if>
              
              
              
               <c:if test="${broj.jmbg.length()<13 }">
                 BROJ NIJE VALIDAN, UNESITE 13 CIFARA
                 <br>
                  <a href="home">Ponovi</a>
              </c:if>
              
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  



