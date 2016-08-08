<!doctype html>
<html>
<head>
	<!-- ## SITE META ## -->
	<meta charset="utf-8">
	<title>Eventicka | Event Landing Page & Ticketing</title>
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="shortcut icon" href="./includes/img/placeholder/favicon.ico">

	<!-- ## LOAD STYLSHEETS ## -->
	<link rel="stylesheet" media="all" href="./includes/css/style.css"/>

	<!-- ## GOOGLE FONTS ## -->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900' rel='stylesheet' type='text/css'>

</head>

<body>

<!-- ## HEADER ## -->
<header id="qcHomeHeader">
	<div class="row">
		<!-- ## LOGO ## -->
		<div id="qcLogo" class="col-6 col">
			<a href="/"><img src="./includes/img/jci_logo.png" style="margin-bottom:-10px" alt="" /><span>  Deinze onderneemt!</span></a>
		</div>


		<!-- ## SITE NAVIGATION ## -->
		<nav id="qcPriNav" class="col-6 col">
			<ul class="clearfix">
				<li><a href="event"><i class="icon-calendar-2 icon"></i> <span>Informatie</span></a></li>
				<li class="current"><a href="reservaties"><i class="icon-ticket icon"></i> <span>Tickets</span></a></li>
			</ul>
		</nav>

	</div>
	<div class="row">

		<!-- ## COUNTDOWN TIMER ## -->
		<div id="qcEventCountDown" class="col-6 col">
			<!-- ## DAYS ## -->
			<div class="dash days_dash">
				<div class="dash_title">dagen</div>
				<div class="digits clearfix">
					<div class="digit digit-1">0</div>
					<div class="digit digit-2">0</div>
					<div class="digit digit-3">0</div>
				</div>
			</div>
			<!-- ## HOURS ## -->
			<div class="dash hours_dash">
				<div class="dash_title">uren</div>
				<div class="digits clearfix">
					<div class="digit digit-1">0</div>
					<div class="digit digit-2">0</div>
				</div>
			</div>
			<!-- ## MINUTES ## -->
			<div class="dash minutes_dash">
				<div class="dash_title">minuten</div>
				<div class="digits clearfix">
					<div class="digit digit-1">0</div>
					<div class="digit digit-2">0</div>
				</div>
			</div>
			<!-- ## SECONDS ## -->
			<div class="dash seconds_dash">
				<div class="dash_title">seconden</div>
				<div class="digits clearfix">
					<div class="digit digit-1">0</div>
					<div class="digit digit-2">0</div>
				</div>
			</div>
		</div>

		<!-- ## EVENT BANNER ## -->
		<div id="qcEventBanner" class="col-6 col">
			<ul>
				<li><b>29-09-2016</b> "De chocolade fabriek"</li>
				<li><b>24-11-2016</b> "Over te nemen/Over te laten"</li>
				<li><b>16-02-2017</b> "U bent?"</li>
				<li><b>Be Better.<span style="font-size:20px;vertical-align: super;">&trade;</span></b></li>
			</ul>
		</div>

	</div>
</header>
<!-- ## HEADER END ## -->

<!-- ## FULLSCREEN SLIDES ## -->
<section id="slideContent">

	<!-- ## SLIDE CONTROLS ## -->
	<div id="qcHomeSlideControls">

		<!-- ## SLIDE DOT NAV ## -->
		<ul id="slide-list"></ul>

		<!-- ## PROGRESS BAR ## -->
		<div id="progress-back" class="load-item">
			<div id="progress-bar"></div>
		</div>

	</div>

</section>
<!-- ## FULLSCREEN SLIDES ## -->

<!-- ## BACKGROUND OVERLAY ## -->
<section id="qcOverlay">
	<div id="qcEventLogo" class="loading">
		<a href="#">
			<img src="http://www.deinze.be/App_Styles/Deinze/images/Logo-Deinze.png" alt=""><span> onderneemt!</span>
		</a>
	</div>
</section>

<!-- ## LOAD JAVASCRIPTS ## -->
<script src="./includes/js/2.1.1.jquery.min.js" type="text/javascript"></script>
<script src="./includes/js/supersized.3.2.7.min.js" type="text/javascript"></script>
<script src="./includes/js/countdown.js" type="text/javascript"></script>
<script src="./includes/js/jquery.marquee.min.js" type="text/javascript"></script>
<script src="./includes/js/library.js" type="text/javascript"></script>
<script src="./includes/js/init.js" type="text/javascript"></script>

<!-- ## FULLSCREEN SLIDESHOW ## -->
<script type="text/javascript">
function slide_fullscreen() {
jQuery(function($){
	$.supersized({
		// Functionality
		slide_interval          :   8000,
		transition              :   1, // 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
		transition_speed	:   1000,
		// Components
		slide_links		:   'blank', // Individual links for each slide (Options: false, 'num', 'name', 'blank')
		progress_bar	:	1,
		slides 			:   [
							{	image : 'http://designbull.co.uk/wp-content/uploads/2015/04/speaking_event_web.jpg'
							},
							{	image : 'http://www.franchiseopportunitiesjournal.com/wp-content/uploads/2014/03/bigstock-Business-Conference-Sized.jpg'
							}
						]
	});
});
}
window.onload = slide_fullscreen;
</script>

</body>

</html>