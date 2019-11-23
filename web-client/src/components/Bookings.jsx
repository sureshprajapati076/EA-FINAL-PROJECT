import React, { Component } from 'react';
import DashboardSidebar from './DashboardSidebar';
class Bookings extends Component {
    state = {  }
    render() { 
        return (  
            <div id="dashboard" >
            
                <a href="#" class="dashboard-responsive-nav-trigger"><i class="fa fa-reorder"></i> Dashboard Navigation</a>
                
                <DashboardSidebar></DashboardSidebar>
            

                {/* <!--  Content
	==================================================  --> */} 
	<div class="dashboard-content">

		{/* <!--  Titlebar  --> */} 
		<div id="titlebar">
			<div class="row">
				<div class="col-md-12">
					<h2>Bookings</h2>
					{/* <!--  Breadcrumbs  --> */} 
					<nav id="breadcrumbs">
						<ul>
							<li><a href="#">Home</a></li>
							<li><a href="#">Dashboard</a></li>
							<li>Bookings</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

		<div class="row">
			
			{/* <!--  Listings  --> */} 
			<div class="col-lg-12 col-md-12">
				<div class="dashboard-list-box margin-top-0">
					
					{/* <!--  Booking Requests Filters   --> */} 
					<div class="booking-requests-filter">

						{/* <!--  Sort by  --> */} 
						<div class="sort-by">
							<div class="sort-by-select">
								<select data-placeholder="Default order" class="chosen-select-no-single">
									<option>All Listings</option>	
									<option>Burger House</option>
									<option>Tom's Restaurant</option>
									<option>Hotel Govendor</option>
								</select>
							</div>
						</div>

						{/* <!--  Date Range  --> */} 
						<div id="booking-date-range">
						    <span></span>
						</div>
					</div>

					{/* <!--  Reply to review popup  --> */} 
					<div id="small-dialog" class="zoom-anim-dialog mfp-hide">
						<div class="small-dialog-header">
							<h3>Send Message</h3>
						</div>
						<div class="message-reply margin-top-0">
							<textarea cols="40" rows="3" placeholder="Your Message to Kathy"></textarea>
							<button class="button">Send</button>
						</div>
					</div>

					<h4>Booking Requests</h4>
					<ul>

						<li class="pending-booking">
							<div class="list-box-listing bookings">
								<div class="list-box-listing-img"><img src="https://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=120" alt="" /></div>
								<div class="list-box-listing-content">
									<div class="inner">
										<h3>Sunny and Modern Apartment <span class="booking-status pending">Pending</span><span class="booking-status unpaid">Unpaid</span></h3>

										<div class="inner-booking-list">
											<h5>Booking Date:</h5>
											<ul class="booking-list">
												<li class="highlighted">20.08.2018 - 24.08.2018</li>
											</ul>
										</div>
													
										<div class="inner-booking-list">
											<h5>Booking Details:</h5>
											<ul class="booking-list">
												<li class="highlighted">2 Adults</li>
											</ul>
										</div>		
													
										<div class="inner-booking-list">
											<h5>Price:</h5>
											<ul class="booking-list">
												<li class="highlighted">$147</li>
											</ul>
										</div>		

										<div class="inner-booking-list">
											<h5>Client:</h5>
											<ul class="booking-list">
												<li>John Smith</li>
												<li><a href="http://www.vasterad.com/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="a3c9cccbcde3c6dbc2ced3cfc68dc0ccce">[email&#160;protected]</a></li>
												<li>123-456-789</li>
											</ul>
										</div>

										<a href="#small-dialog" class="rate-review popup-with-zoom-anim"><i class="sl sl-icon-envelope-open"></i> Send Message</a>

									</div>
								</div>
							</div>
							<div class="buttons-to-right">
								<a href="#" class="button gray reject"><i class="sl sl-icon-close"></i> Reject</a>
								<a href="#" class="button gray approve"><i class="sl sl-icon-check"></i> Approve</a>
							</div>
						</li>

						<li class="approved-booking">
							<div class="list-box-listing bookings">
								<div class="list-box-listing-img"><img src="https://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=120" alt="" /></div>
								<div class="list-box-listing-content">
									<div class="inner">
										<h3>Burger House <span class="booking-status">Approved</span></h3>

										<div class="inner-booking-list">
											<h5>Booking Date:</h5>
											<ul class="booking-list">
												<li class="highlighted">10.12.2019 at 12:30 pm - 13:30 pm</li>
											</ul>
										</div>
													
										<div class="inner-booking-list">
											<h5>Booking Details:</h5>
											<ul class="booking-list">
												<li class="highlighted">2 Adults, 2 Children</li>
											</ul>
										</div>		

										<div class="inner-booking-list">
											<h5>Client:</h5>
											<ul class="booking-list">
												<li>Kathy Brown</li>
												<li><a href="http://www.vasterad.com/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="5d363c2935241d38253c302d3138733e3230">[email&#160;protected]</a></li>
												<li>123-456-789</li>
											</ul>
										</div>

										<a href="#small-dialog" class="rate-review popup-with-zoom-anim"><i class="sl sl-icon-envelope-open"></i> Send Message</a>

									</div>
								</div>
							</div>
							<div class="buttons-to-right">
								<a href="#" class="button gray reject"><i class="sl sl-icon-close"></i> Cancel</a>
							</div>
						</li>

						<li class="canceled-booking">
							<div class="list-box-listing bookings">
								<div class="list-box-listing-img"><img src="https://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=120" alt="" /></div>
								<div class="list-box-listing-content">
									<div class="inner">
										<h3>Tom's Restaurant <span class="booking-status">Canceled</span></h3>

										<div class="inner-booking-list">
											<h5>Booking Date:</h5>
											<ul class="booking-list">
												<li class="highlighted">21.10.2019 at 9:30 am - 10:30 am</li>
											</ul>
										</div>
													
										<div class="inner-booking-list">
											<h5>Booking Details:</h5>
											<ul class="booking-list">
												<li class="highlighted">2 Adults</li>
											</ul>
										</div>		

										<div class="inner-booking-list">
											<h5>Client:</h5>
											<ul class="booking-list">
												<li>Kathy Brown</li>
												<li><a href="http://www.vasterad.com/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="c6ada7b2aebf86a3bea7abb6aaa3e8a5a9ab">[email&#160;protected]</a></li>
												<li>123-456-789</li>
											</ul>
										</div>

									</div>
								</div>
							</div>
						</li>
						
					</ul>
				</div>
			</div>


			{/* <!--  Copyrights  --> */} 
			<div class="col-md-12">
				<div class="copyrights">© 2019 Listeo. All Rights Reserved.</div>
			</div>
		</div>

	</div>
	{/* <!--  Content / End  --> */} 
            

            
            
            </div>
        );
    }
}
 
export default Bookings;