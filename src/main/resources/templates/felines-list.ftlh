<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
  <body style="margin: 0; padding: 0;background-color: lightgray;">
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
    <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
            <span class="navbar-text">
                Welcome to our Animal Information Page!
            </span>
            <form action="">
                <input type="text" placeholder="Search.." >
                <button type="submit">Submit</button>
            </form>
        </div>
    </nav>
    <header style="text-align: center; padding: 10px; margin: 0; padding-left: 25%; padding-right: 25%;">
        <h1>Explore Amazing Animals!</h1>
        <p>Dive into the fascinating world of animals. Discover unique facts, stunning images, and more about your favorite creatures.
             Click on the Name of an animal to learn more about it!</p>
    </header>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th style="text-align:center;">Name</th>
        <th style="text-align:center;">Image</th>
        <th style="text-align:center;">Description</th>
      </tr>
    </thead>
    <tbody>
      <#list felines as feline>
        <tr>
          <td style="text-align:center;">
            <a href="/felines/${feline.id?c}" style="text-decoration:none; color:inherit;">
              ${feline.name!''}
            </a>
          </td>

          <td style="text-align:center;">
            <img src="${feline.imageUrl!'avatar.png'}" 
                alt="${feline.name!''}" 
                style="height:200px; width:200px; object-fit:cover;">
          </td>

          <td style="text-align:center;">
            ${feline.description!''}
          </td>
        </tr>
      </#list>
   </tbody>
  </table>
    <br><br>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>