<?php
// Ελέγχουμε αν έχουν σταλεί τα σωστά στοιχεία εισόδου
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = $_POST['username'];
    $password = $_POST['password'];

    // ελεγχος στοιχειων
    if ($username === 'admin' && $password === 'Root123') {

        $requests = getRequests(); 

        $response = [
            'success' => true,
            'requests' => $requests
        ];

        echo json_encode($response);
    } else {

        $response = [
            'success' => false,
            'message' => 'Λυπούμαστε, δεν είστε διαχειριστής της διαδικτυακής εφαρμογής'
        ];

        echo json_encode($response);
    }
}

function getRequests()
{
    $servername = "127.0.0.1";
    $username = "root";
    $password = "";
    $dbname = "gasdb";

    $conn = new mysqli($servername, $username, $password, $dbname);


    if ($conn->connect_error) {
        die("Σφάλμα κατά τη σύνδεση στη βάση δεδομένων: " . $conn->connect_error);
    }

    // παιρνουμε τα στοιχεια του request
    $sql = "SELECT name, phone, department, email, subject, message FROM requests";
    $result = $conn->query($sql);

    $requests = array();

    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $request = array(
                'name' => $row['name'],
                'phone' => $row['phone'],
                'department' => $row['department'],
                'email' => $row['email'],
                'subject' => $row['subject'],
                'message' => $row['message']
            );
            array_push($requests, $request);
        }
    }

    $conn->close();

    return $requests;
}
?>
