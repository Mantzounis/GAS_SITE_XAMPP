<?php
// Στοιχεία σύνδεσης με τη βάση δεδομένων
$servername = "127.0.0.1";
$username = "root";
$password = "";
$dbname = "gasdb";

$conn = new mysqli($servername, $username, $password, $dbname);


if ($conn->connect_error) {
    die("Απέτυχε η σύνδεση με τη βάση δεδομένων: " . $conn->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST["name"];
    $phone = $_POST["phone"];
    $department = $_POST["department"];
    $email = $_POST["email"];
    $subject = $_POST["subject"];
    $message = $_POST["message"];

    if ($name && $phone && $department && $email && $subject && $message) {
        // Εισαγωγή των δεδομένων στον πίνακα "requests"
        $sql = "INSERT INTO requests (name, phone, department, email, subject, message)
                VALUES ('$name', '$phone', '$department', '$email', '$subject', '$message')";

if ($conn->query($sql) === TRUE) {
    echo '<script>
            alert("Το μήνυμα στάλθηκε επιτυχώς!");
            window.location.href = "contact.html";
          </script>';
} else {
    echo '<script>
            alert("Σφάλμα κατά την αποστολή: ' . $conn->error . '");
            window.location.href = "contact.html";
          </script>';
}
}
}
$conn->close();
?>