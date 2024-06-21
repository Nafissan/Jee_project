<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Ajouter un utilisateur</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
     <style>
        body {
            margin-top: 100px;
            margin-bottom: 60px;
        }
        .btn-custom {
            background-color: #007bff;
            color: white;
        }
        .btn-custom:hover {
            background-color: #0056b3;
        }
        .card-header {
            background-color: #007bff;
            color: white;
        }
        .user-photo {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            cursor: pointer;
            text-align: center;
        }
        .user-photo img {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            border: 2px solid #007bff;
        }
        .footer {
            background-color: #343a40;
            color: white;
            padding: 10px 0;
            text-align: center;
            border-top: 1px solid #e7e7e7;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
        .title-bar {
            background-color: #343a40;
            color: white;
            padding: 10px 0;
            text-align: center;
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 1000;
        }
    </style>
</head>
<body>
    <div class="title-bar">
        <h1>Ajouter un utilisateur</h1>
    </div>
    <div class="container">
        <div class="card mt-5">
            <div class="card-body">
                <form action="Add" method="post" >
                  
                    <div class="form-group">
                        <label for="prenom">Prénom :</label>
                        <input type="text" class="form-control" name="prenom" required>
                    </div>
                    <div class="form-group">
                        <label for="nom">Nom :</label>
                        <input type="text" class="form-control" name="nom" required>
                    </div>
                    <div class="form-group">
                        <label for="login">Login :</label>
                        <input type="text" class="form-control" name="login" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Mot de passe :</label>
                        <input type="password" class="form-control" name="password" required>
                    </div>
                    <div class="form-group">
                        <label for="mail">Email :</label>
                        <input type="text" class="form-control" name="mail" required>
                    </div>
                    <div class="form-group">
                        <label for="lieuNaissance">Lieu de naissance :</label>
                        <input type="text" class="form-control" name="lieuNaissance" required>
                    </div>
                    <div class="form-group">
                        <label for="lieuNaissance">Date de naissance :</label>
                        <input type="date" class="form-control" name="dateNaissance" required>
                    </div>
                    <div class="form-group">
                        <label for="telephone">Téléphone :</label>
                        <input type="text" class="form-control" name="telephone" required>
                    </div>
                    <div class="form-group">
                        <label for="sexe">Sexe :</label>
                        <select class="form-control" name="sexe" required>
                            <option value="">Sélectionnez</option>
                            <option value="masculin">Homme</option>
                            <option value="feminin">Femme</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-custom">Ajouter</button>
                     <a  class="btn btn-secondary" href="<c:url value='/list'/>">Retour</a>
                    
                </form>
            </div>
        </div>
    </div>

    <div class="footer">
        <p>&copy; 2024 DIC3-INFO</p>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>       
</body>
</html>