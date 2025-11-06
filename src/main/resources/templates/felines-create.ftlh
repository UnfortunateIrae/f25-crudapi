<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Animal Form</title>
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
                color:white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover {
                background-color: #111;
            }
        </style>
        <li><a href="index.html">Home</a></li>
        <li><a href="details.html">Details</a></li>
        <li><a href="about.html">About</a></li>
        <li><a href="new-animal-form.html">New Animal Form</a></li>
    </ul>
    <style>
    h1 {
        text-align: center;
    }
    </style>
    <h1 style="background-color:lightcyan;">Tell us about the animal you would like displayed!</h1>
    <form>
        <style>
            form {
                margin: 20px;
            }

            label {
                font-weight: bold;
            }

            input[type="text"] {
                text-align: left;
                padding: 8px;
                margin: 8px 0;
                box-sizing: border-box;
            }
        </style>
        <label for="fname">Common Name:</label><br>
        <input type="text" id="fname" name="fname" placeholder="Enter Common Name"><br>

        <label for="lname">Scientific Name:</label><br>
        <input type="text" id="lname" name="lname" style="width: 50%;" placeholder="Enter Scientific Name"><br>

        <label for="diet">Typical Diet :</label><br>

        <input type="radio" id="carni" name="diet" value="Carnivore">
        <label for="carni">Carnivore</label><br>
        <input type="radio" id="omni" name="diet" value="Omnivore">
        <label for="omni">Omnivore</label><br>
        <input type="radio" id="herbi" name="diet" value="Herbivore">
        <label for="herbi">Herbivore</label><br><br

        <label for="diet">Covering :</label><br>

        <input type="radio" id="fur" name="cover" value="Fur">
        <label for="fur">Fur</label><br>
        <input type="radio" id="scale" name="cover" value="Scales">
        <label for="scale">Scales</label><br>
        <input type="radio" id="feat" name="cover" value="Feathers">
        <label for="feat">Feathers</label><br>
        <input type="radio" id="skin" name="cover" value="Skin">
        <label for="skin">Skin</label><br><br>

        <label for="porc">Pattern/Color:</label><br>
        <input type="text" id="porc" name="porc" placeholder="Describe its pattern/color" style="width: 50%;"><br>
        <br>

        <label for="move">Movement Style:</label><br>
        <input type="text" id="move" name="move" placeholder="Describe the way it moves" style="width: 50%;"><br>
        <br>

        <label for="behav">Behavior:</label><br>
        <input type="text" id="behav" name="behav" placeholder="How does it act?" style="width: 50%;"><br>
        <br>

        <label for="habit">Habitat:</label><br>
        <input type="text" id="habit" name="habit" placeholder="Where does it live?" style="width: 50%;"><br>
        <br>
        <input type="submit" value="Add an animal!" style="background-color: lightcyan;">
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>