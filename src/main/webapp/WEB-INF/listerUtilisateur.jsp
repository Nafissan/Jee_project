<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des utilisateurs</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
    <style type="text/css">
    .btn-custom {
            background-color: #242533;
            color: white;
        }
        .btn-custom:hover {
            background-color: #0056b3;
        }
        .footer {
            background-color: #343a40;
            padding: 10px 0;
            text-align: center;
            border-top: 1px solid #e7e7e7;
            position: fixed;
            bottom: 0;
            width: 100%;
            color: white;
            
        }
        .table-container {
            margin-top: 20px;
        }
        .table th, .table td {
            text-align: center;
        }
        .card-header {
            background-color: #343a40;
            color: white;
        }
        .modal-content {
            background-color: #f8f9fa;
        }
        .fixed-header {
            background-color: #343a40;
            color: white;
            padding: 10px 0;
            text-align: center;
            margin-bottom: 20px;
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 1000;
        }
        .content {
            margin-top: 150px; /* Adjust this value if the fixed header height changes */
            padding-bottom: 60px;
            } /* Space for the fixed footer */
        .info{
        background-color: #343a40;
        }
    </style>
</head>
<body>
    <div class="fixed-header">
        <h1 class="my-4 text-center">Gestion des utilisateurs</h1>
    </div>
    <div class="container content">
        <div class="card">
            <div class="card-header">
                <h2 class="my-0">Liste des utilisateurs</h2>
                <a href="<c:url value='/Add'/>" class="btn btn-custom float-right">Ajouter Utilisateur</a>
            </div>
            <div class="card-body">
                <c:choose>
                    <c:when test="${empty utilisateurs}">
                        <p>Désolé, la liste est vide</p>
                    </c:when>
                    <c:otherwise>
                        <div class="table-responsive">
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>Prénom</th>
                                        <th>Nom</th>
                                        <th>Login</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items='${utilisateurs}' var="utilisateur">
    <tr data-userid="${utilisateur.id}">
        <td>${utilisateur.prenom}</td>
        <td>${utilisateur.nom}</td>
        <td>${utilisateur.login}</td>
        <td>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item show-info" href="#" data-toggle="modal" data-target="#viewModal${utilisateur.id}">Afficher</a> <!-- Modifier cette ligne -->
                    <a class="dropdown-item" href="<c:url value='/Update?id=${utilisateur.id}'/>">Modifier</a>
                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#confirmDeleteModal${utilisateur.id}">Supprimer</a>
                </div>
            </div>
        </td>
    </tr>
</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

    <!-- Modal pour l'affichage des informations de l'utilisateur -->
    <c:forEach items='${utilisateurs}' var="utilisateur">
<div class="modal fade" id="viewModal${utilisateur.id}" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel${utilisateur.id}" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header bg-primary text-white info">
                <h5 class="modal-title" id="viewModalLabel${utilisateur.id}">Informations de l'utilisateur</h5>
                <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <c:if test="${not empty utilisateur}">
                <div class="modal-body">
                    <div class="row mb-3">
                        <div class="col-md-4">
                            <img src="asset/${utilisateur.image }" class="img-fluid rounded-circle" alt="Photo de profil">
                        </div>
                        <div class="col-md-8">
                            <h5>${utilisateur.prenom} ${utilisateur.nom}</h5>
                            <p><strong>Login :</strong> ${utilisateur.login}</p>
                            <p><strong>Date de naissance :</strong> ${utilisateur.dateNaissance}</p>
                        </div>
                    </div>
                    <hr>
                   <div class="row">
                            <div class="col-md-6">
                                <p><i class="fas fa-map-marker-alt"></i> <strong>Lieu de Naissance :</strong> ${utilisateur.lieuNaissance}</p>
                                <p><i class="fas fa-envelope"></i> <strong>Email :</strong> ${utilisateur.mail}</p>
                            </div>
                            <div class="col-md-6">
                                <p><i class="fas fa-phone"></i> <strong>Telephone :</strong> ${utilisateur.telephone}</p>
                                <p><i class="fas fa-venus-mars"></i> <strong>Sexe :</strong> ${utilisateur.sexe}</p>
                            </div>
                        </div>
                    </div>
            </c:if>
        </div>
    </div>
</div>

         <!-- Ajout du modal de confirmation pour la suppression -->
                <div class="modal fade" id="confirmDeleteModal${utilisateur.id}" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel${utilisateur.id}" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="confirmDeleteModalLabel${utilisateur.id}">Confirmation de suppression</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <p>Êtes-vous sûr de vouloir supprimer l'utilisateur "${utilisateur.nom} ${utilisateur.prenom}" ?</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                                <a href="<c:url value='/Delete?id=${utilisateur.id}'/>" class="btn btn-danger">Supprimer</a>
                            </div>
                        </div>
                    </div>
                    </div>
    </c:forEach>

    <div class="footer">
        <p>&copy; 2024 DIC3-INFO</p>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    
</body>
</html>
