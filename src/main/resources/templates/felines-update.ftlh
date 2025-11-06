<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Update Feline</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
        crossorigin="anonymous">
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
      li { float: left; }
      li a {
        display: block;
        color:white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
      }
      li a:hover { background-color: #111; }
    </style>

    <li><a href="index.html">Home</a></li>
    <li><a href="details.html">Details</a></li>
    <li><a href="about.html">About</a></li>
    <li><a href="update-feline.html">Update Feline</a></li>
  </ul>

  <h1 style="text-align:center;background-color:lightcyan;">Update Existing Feline</h1>

  <!-- Change the action to your backend update endpoint -->
  <form method="POST" action="/felines/update" class="container mt-4">
    <!-- Hidden id of the existing feline -->
    <input type="hidden" name="id" value="12345">

    <label for="fname" class="fw-bold">Name:</label>
    <input type="text" id="fname" name="name" class="form-control"
           placeholder="Enter Feline Name" required>

    <label for="lname" class="fw-bold mt-3">Breed:</label>
    <input type="text" id="lname" name="breed" class="form-control"
           placeholder="Enter Breed">

    <label class="fw-bold mt-3">Diet:</label><br>
    <input type="radio" id="carni" name="diet" value="Carnivore">
    <label for="carni">Carnivore</label><br>
    <input type="radio" id="omni" name="diet" value="Omnivore">
    <label for="omni">Omnivore</label><br>
    <input type="radio" id="herbi" name="diet" value="Herbivore">
    <label for="herbi">Herbivore</label><br><br>

    <label class="fw-bold">Fur Pattern / Color:</label>
    <input type="text" id="porc" name="color" class="form-control"
           placeholder="Describe pattern & color">

    <label for="vacc" class="fw-bold mt-3">Vaccinated:</label>
    <select id="vacc" name="vaccinated" class="form-select" style="width: fit-content;">
      <option value="yes">Yes</option>
      <option value="no">No</option>
    </select>

    <label for="notes" class="fw-bold mt-3">Notes:</label>
    <textarea id="notes" name="notes" class="form-control" rows="3"
              placeholder="Behavior, temperament, health notes"></textarea>

    <input type="submit"
           value="Save Changes"
           class="btn mt-4"
           style="background-color: lightcyan;">
  </form>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
          crossorigin="anonymous"></script>
</body>
</html>
