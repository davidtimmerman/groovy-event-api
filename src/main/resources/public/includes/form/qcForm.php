<?php
// Replace your@email.com 
$mailTo = 'your@email.com';

if ($_POST['formtype'] == 'ticket') {
	$subject = ('Ticket Form').' [ '.$_SERVER["HTTP_HOST"].' ] ';
	$name = $_POST['name'];
	$email = $_POST['email'];
	$phone = $_POST['phone'];
	$ticket = $_POST['ticket'];
	$quantity = $_POST['quantity'];		
	$body = ("Name: $name \n\nEmail: $email \n\nPhone: $phone \n\nTicket: $ticket \n\nQuantity: $quantity" );
} 
if ($_POST['formtype'] == 'contact') {
	$subject = ('Contact Form').' [ '.$_SERVER["HTTP_HOST"].' ] ';
	$name = $_POST['contact-name'];
	$email = $_POST['contact-email'];
	$phone = $_POST['contact-phone'];
	$regarding = $_POST['contact-subject'];
	$message = $_POST['contact-message'];
	$body = ("Name: $name \n\nEmail: $email \n\nPhone: $phone \n\nSubject: $regarding \n\nMessage: $message" );
}

$headers = ('From:') .' <'.$name.'>' . "\r\n" . ('Reply-To:') . $email;
mail($mailTo, $subject, $body, $headers);
?>