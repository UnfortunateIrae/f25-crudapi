<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title!}</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body style="margin-bottom: 50px; background-color: gray;">

<ul style="list-style-type:none; margin:0; padding:0; overflow:hidden; background-color:#333;">
    <li style="float:left;"><a href="/felines"
                               style="display:block;color:white;text-align:center;padding:14px 16px;text-decoration:none;">Home</a></li>
</ul>

<div class="container mt-4" style="text-align:center;">
    <h1>${title!}</h1>

    <div class="card mx-auto" style="max-width: 600px;">
        <h5 class="card-header">${feline.name!}</h5>

        <img src="${feline.imageUrl!}" alt="${feline.name!}"
             style="height: 200px; width: 200px; object-fit: cover; margin:auto;">

        <div class="card-body">
            <h5 class="card-title">ID: ${feline.id!}</h5>

            <p class="card-text"><strong>Name:</strong> ${feline.name!}</p>
            <p class="card-text"><strong>Habitat:</strong> ${feline.habitat!}</p>
            <p class="card-text"><strong>Weight:</strong> ${feline.weight!} lbs</p>
            <p class="card-text"><strong>Population:</strong> ${feline.population!}</p>
            <p class="card-text"><strong>Description:</strong> ${feline.description!}</p>

            <a href="/felines/updateForm/${feline.id?c}" class="btn btn-primary">Edit</a>
            <a href="/felines/delete/${feline.id?c}" class="btn btn-danger">Delete</a>
            <a href="/felines" class="btn btn-secondary">Back</a>
        </div>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
