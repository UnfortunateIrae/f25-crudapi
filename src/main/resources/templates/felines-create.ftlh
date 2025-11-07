<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>${title!}</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body style="margin:0; padding:0; background-color: lightgray;">
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
        <li><a href="/felines/createForm">New Animal Form</a></li>
    </ul>

<ul style="list-style:none; margin:0; padding:0; overflow:hidden; background-color:#333;">
    <li style="float:left;"><a href="/felines" style="display:block;color:white;text-align:center;padding:14px 16px;text-decoration:none;">Home</a></li>
</ul>

<h1 style="text-align:center; background-color:lightcyan;">Add a New Feline</h1>

<form method="POST" action="/felines" class="container mt-4">
    <label class="fw-bold">Name:</label>
    <input type="text" name="name" class="form-control" value="${feline.name!}" placeholder="Enter Name" required>

    <label class="fw-bold mt-3">Image URL:</label>
    <input type="text" name="imageUrl" class="form-control" value="${feline.imageUrl!}" placeholder="Enter Image URL" required>

    <label class="fw-bold mt-3">Habitat:</label>
    <input type="text" name="habitat" class="form-control" value="${feline.habitat!}" placeholder="Enter Habitat">

    <label class="fw-bold mt-3">Weight:</label>
    <input type="number" step="0.1" name="weight" class="form-control" value="${feline.weight!}" placeholder="Enter Weight">

    <label class="fw-bold mt-3">Population:</label>
    <input type="number" name="population" class="form-control" value="${feline.population!}" placeholder="Enter Population">

    <label class="fw-bold mt-3">Description:</label>
    <textarea name="description" class="form-control" rows="3" placeholder="Enter Description">${feline.description!}</textarea>

    <input type="submit" value="Add Feline" class="btn mt-4" style="background-color: lightcyan;">
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
