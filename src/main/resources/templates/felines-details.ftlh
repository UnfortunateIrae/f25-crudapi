<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Feline Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
  <body style="margin-bottom: 50px; padding: 0;background-color: gray;">
    <ul>
        <style>
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover {
                background-color: #111;
            }
        </style>
        <li><a href="/felines">Home</a></li>
    </ul>
    <div style="text-align: center;">
      <h1>${title}</h1>
      <div class="card">
      <h5 class="card-header">${largeFeline.name}</h5>
      <img src="/profile-pictures/${(student.profilePicturePath)!'avatar.png'}" class="card-img-top"
        style="height: 100px; width: 100px;" alt="profile picture">
      <div class="card-body">
        <span style="float:right"> <a href="/students/updateForm/${student.studentId?c}" class="btn btn-primary">Edit
            Student</a></span>
        <h5 class="card-title">ID: ${largeFeline.felineId?c}</h5>
        <p class="card-text">Habitat: ${largeFeline.habitat}</p>
        <p class="card-text">Name: ${largeFeline.name}</p>
        <p class="card-text">Weight: ${largeFeline.weight}</p>
        <p class="card-text">Population: ${largeFeline.population}</p>
        <p class="card-text">Description: ${largeFeline.description}
        <a href="/felines/delete/${largeFeline.felineId?c}" class="btn btn-danger">Delete
          Feline</a>

        <a href="/felines" class="btn btn-primary">Go back</a>
      </div>
    </div>
    <br>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>