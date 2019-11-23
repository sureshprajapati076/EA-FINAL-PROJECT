import React, { Component } from 'react';
import { BrowserRouter as Router , Link , NavLink , Prompt } from 'react-router-dom';
import axios from 'axios';
class SingleAppartment extends Component {
    state = { 
        apartments:[{},{}]
     }

    componentDidMount() {
        axios({
          url: "http://localhost:8080/graphql",
          method: "post",
          data: {
            query: `
              query {
                apartments(count: 2) 
                {
                  id, 
                  title, 
                  details,
                  imageUrl
              }
              }
                `
          }
        }).then(result => 
          this.setState({apartments: result.data.data.apartments})
        
        );
      }

    render() { 
        const { apartments} = this.state
        const apartment = apartments[0];
        console.log(apartment)
        return ( 
            <div class="container">
                <div class="row sticky-wrapper">
                    <div class="col-lg-8 col-md-8 padding-right-30">
            
                        {/* <!--  Titlebar  --> */} 
                        <div id="titlebar" class="listing-titlebar">
                            <div class="listing-titlebar-title">
                                <h2>{apartment.title}<span class="listing-tag">Apartments</span></h2>
                                <span>
                                    <a href="#listing-location" class="listing-address">
                                        <i class="fa fa-map-marker"></i>
                                        {apartment.location}
                                    </a>
                                </span>
                                <div class="star-rating" data-rating="5">
                                    <div class="rating-counter"><a href="#listing-reviews">(1 reviews)</a></div>
                                </div>
                            </div>
                        </div>
            
                        {/* <!--  Listing Nav  --> */} 
                        <div id="listing-nav" class="listing-nav-container">
                            <ul class="listing-nav">
                                <li><a href="#listing-overview" class="active">Overview</a></li>
                            </ul>
                        </div>
                        
                        {/* <!--  Overview  --> */} 
                        <div id="listing-overview" class="listing-section">
            
                            {/* <!--  Apartment Description  --> */} 
                            <ul class="apartment-details">
                                <li>2 rooms</li>
                                <li>1 bedroom</li>
                                <li>1 bed</li>
                                <li>1 bathroom</li>
                            </ul>
            
                            {/* <!--  Description  --> */} 
                            <p>
                            {apartment.details}
                            </p>
            
                            
            
                            
                            {/* <!--  Listing Contacts  --> */} 
                            <div class="listing-links-container">
            
                              

                            </div>
                            <div class="clearfix"></div>
            
            
                            {/* <!--  Amenities  --> */} 
                            <h3 class="listing-desc-headline">Amenities</h3>
                            <ul class="listing-features checkboxes">
                                <li>Elevator in building</li>
                                <li>Friendly workspace</li>
                                <li>Instant Book</li>
                                <li>Wireless Internet</li>
                                <li>Free parking on premises</li>
                                <li>Free parking on street</li>
                            </ul>
                        </div>
            
            
                        {/* <!--  Slider  --> */} 
                        <div id="listing-gallery" class="listing-section">
                            <h3 class="listing-desc-headline margin-top-70">Gallery</h3>
                            <div class="listing-slider-small mfp-gallery-container margin-bottom-0">
                                <a href="images/single-listing-02a.jpg" data-background-image={apartment.imageUrl} class="item mfp-gallery" title="Title 2"></a>
                                
                            </div>
                        </div>
            
                            
                        {/* <!--  Reviews  --> */} 
                        <div id="listing-reviews" class="listing-section">
                            <h3 class="listing-desc-headline margin-top-75 margin-bottom-20">Reviews <span>(12)</span></h3>
            
                            {/* <!--  Rating Overview  --> */} 
                            <div class="rating-overview">
                                <div class="rating-overview-box">
                                    <span class="rating-overview-box-total">4.7</span>
                                    <span class="rating-overview-box-percent">out of 5.0</span>
                                    <div class="star-rating" data-rating="5"></div>
                                </div>
            
                                <div class="rating-bars">
                                       
                                       
                                </div>
                            </div>
                            {/* <!--  Rating Overview / End  --> */} 
            
            
                            <div class="clearfix"></div>
            
                            {/* <!--  Reviews  --> */} 
                            <section class="comments listing-reviews">
                                <ul>
                                    <li>
                                        <div class="avatar"><img src="https://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
                                        <div class="comment-content"><div class="arrow-comment"></div>
                                            <div class="comment-by">Brian Bwengye <i class="tip" data-tip-content="Person who left this review actually was a customer"></i> <span class="date">2019</span>
                                                <div class="star-rating" data-rating="5"></div>
                                            </div>
                                            <p>Very Great place. I enjoyed </p>
                                            <a href="#" class="rate-review"><i class="sl sl-icon-like"></i> Helpful Review <span>12</span></a>
                                        </div>
                                    </li>
            
                               
                                 </ul>
                            </section>
            
                            {/* <!--  Pagination  --> */} 
                            <div class="clearfix"></div>
                            <div class="row">
                                <div class="col-md-12">
                                    {/* <!--  Pagination  --> */} 
                                    <div class="pagination-container margin-top-30">
                                        <nav class="pagination">
                                            <ul>
                                                <li><a href="#" class="current-page">1</a></li>
                                                <li><a href="#">2</a></li>
                                                <li><a href="#"><i class="sl sl-icon-arrow-right"></i></a></li>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            {/* <!--  Pagination / End  --> */} 
                        </div>
            
            
                        {/* <!--  Add Review Box  --> */} 
                        <div id="add-review" class="add-review-box">
            
                            {/* <!--  Add Review  --> */} 
                            <h3 class="listing-desc-headline margin-bottom-10">Add Review</h3>
                            <p class="comment-notes">Your email address will not be published.</p>
            
                            {/* <!--  Subratings Container  --> */} 
                            <div class="sub-ratings-container">
            
                          
            
                          
                                
                                {/* <!--  Subrating #4  --> */} 
                                <div class="add-sub-rating">
                                    <div class="sub-rating-title">Cleanliness <i class="tip" data-tip-content="The physical condition of the business"></i></div>
                                    <div class="sub-rating-stars">
                                        {/* <!--  Leave Rating  --> */} 
                                        <div class="clearfix"></div>
                                        <form class="leave-rating">
                                            <input type="radio" name="rating" id="rating-31" value="1"/>
                                            <label for="rating-31" class="fa fa-star"></label>
                                            <input type="radio" name="rating" id="rating-32" value="2"/>
                                            <label for="rating-32" class="fa fa-star"></label>
                                            <input type="radio" name="rating" id="rating-33" value="3"/>
                                            <label for="rating-33" class="fa fa-star"></label>
                                            <input type="radio" name="rating" id="rating-34" value="4"/>
                                            <label for="rating-34" class="fa fa-star"></label>
                                            <input type="radio" name="rating" id="rating-35" value="5"/>
                                            <label for="rating-35" class="fa fa-star"></label>
                                        </form>
                                    </div>
                                </div>	
            
                                {/* <!--  Uplaod Photos  --> */} 
                                <div class="uploadButton margin-top-15">
                                    <input class="uploadButton-input" type="file"  name="attachments[]" accept="image/*, application/pdf" id="upload" multiple/>
                                    <label class="uploadButton-button ripple-effect" for="upload">Add Photos</label>
                                    <span class="uploadButton-file-name"></span>
                                </div>
                                {/* <!--  Uplaod Photos / End  --> */} 
            
                            </div>
                            {/* <!--  Subratings Container / End  --> */} 
            
                            {/* <!--  Review Comment  --> */} 
                            <form id="add-comment" class="add-comment">
                                <fieldset>
            
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>Name:</label>
                                            <input type="text" value=""/>
                                        </div>
                                            
                                        <div class="col-md-6">
                                            <label>Email:</label>
                                            <input type="text" value=""/>
                                        </div>
                                    </div>
            
                                    <div>
                                        <label>Review:</label>
                                        <textarea cols="40" rows="3"></textarea>
                                    </div>
            
                                </fieldset>
            
                                <button class="button">Submit Review</button>
                                <div class="clearfix"></div>
                            </form>
            
                        </div>
                        {/* <!--  Add Review Box / End  --> */} 
            
            
                    </div>
            
            
                    {/* <!--  Sidebar
                    ==================================================  --> */} 
                    <div class="col-lg-4 col-md-4 margin-top-75 sticky">
            
                            
                        {/* <!--  Verified Badge  --> */} 
                        <div class="verified-badge with-tip" data-tip-content="Listing has been verified and belongs the business owner or manager.">
                            <i class="sl sl-icon-check"></i> Verified Listing
                        </div>
            
                        {/* <!--  Book Now  --> */} 
                        <div id="booking-widget-anchor" class="boxed-widget booking-widget margin-top-35">
                            <h3><i class="fa fa-calendar-check-o "></i> Booking</h3>
                            <div class="row with-forms  margin-top-0">
            
                                {/* <!--  Date Range Picker - docs: http://www.daterangepicker.com/  --> */} 
                                <div class="col-lg-12">
                                    <input type="date" id="date-picker" placeholder="Date"  />
                                </div>
            
                                {/* <!--  Panel Dropdown  --> */} 
                                <div class="col-lg-12">
                                    <div class="panel-dropdown">
                                        <a href="#">Guests <span class="qtyTotal" name="qtyTotal">1</span></a>
                                        <div class="panel-dropdown-content">
            
                                            {/* <!--  Quantity Buttons  --> */} 
                                            <div class="qtyButtons">
                                                <div class="qtyTitle">Adults</div>
                                                <input type="text" name="qtyInput" value="1" />
                                            </div>
            
                                            <div class="qtyButtons">
                                                <div class="qtyTitle">Childrens</div>
                                                <input type="text" name="qtyInput" value="0" />
                                            </div>
            
                                        </div>
                                    </div>
                                </div>
                                {/* <!--  Panel Dropdown / End  --> */} 
            
                            </div>
                            
                            {/* <!--  Book Now  --> */} 
                            <NavLink to="/book"  class="button book-now fullwidth margin-top-5">Request To Book</NavLink>
                            
                            {/* <!--  Estimated Cost  --> */} 
            {/* <!--  				<div class="booking-estimated-cost">
                                <strong>Total Cost</strong>
                                <span>$49</span>
                            </div>  --> */} 
                        </div>
                        {/* <!--  Book Now / End  --> */} 
            
                        {/* <!--  Contact  --> */} 
                        <div class="boxed-widget margin-top-35">
                            <div class="hosted-by-title">
                                <h4><span>Hosted by</span> <a href="pages-user-profile.html">Brian Bwengye</a></h4>
                                <a href="pages-user-profile.html" class="hosted-by-avatar"><img src="data:image/jpeg;base64,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" alt="" /></a>
                            </div>
                            <ul class="listing-details-sidebar">
                                <li><i class="sl sl-icon-phone"></i> (123) 123-456</li>
                                {/* <!--  <li><i class="sl sl-icon-globe"></i> <a href="#">http://example.com</a></li>  --> */} 
                                <li><i class="fa fa-envelope-o"></i> <a href="#"><span class="__cf_email__" data-cfemail="14607b7954716c75796478713a777b79">[email&#160;protected]</span></a></li>
                            </ul>
            
                
            
                            {/* <!--  Reply to review popup  --> */} 
                            <div id="small-dialog" class="zoom-anim-dialog mfp-hide">
                                <div class="small-dialog-header">
                                    <h3>Send Message</h3>
                                </div>
                                <div class="message-reply margin-top-0">
                                 
                                 
                                </div>
                            </div>
            
                            
                        </div>
                        {/* <!--  Contact / End --> */} 
            

            
                    </div>
                    {/* <!--  Sidebar / End  --> */} 
            
                </div>
            </div> );
    }
}
 
export default SingleAppartment;