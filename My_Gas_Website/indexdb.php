<?php
// Στοιχεία σύνδεσης με τη βάση δεδομένων
$servername = "127.0.0.1";
$username = "root";
$password = "";
$dbname = "gasdb";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Αποτυχία σύνδεσης με τη βάση δεδομένων: " . $conn->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Λαμβάνουμε τις τιμές από τη φόρμα
    $username = $_POST["username"];
    $name = $_POST["name"];
    $email = $_POST["email"];

    $sql = "INSERT INTO subscribers (username, name, email) VALUES ('$username', '$name', '$email')";

if ($conn->query($sql) === TRUE) {
    echo '<script>
            alert("Η εγγραφή ολοκληρώθηκε επιτυχώς!");
            window.location.href = "index.html";
          </script>';
} else {
    echo '<script>
            alert("Σφάλμα κατά την εγγραφή: ' . $conn->error . '");
            window.location.href = "index.html";
          </script>';
}
}

$conn->close();
?>