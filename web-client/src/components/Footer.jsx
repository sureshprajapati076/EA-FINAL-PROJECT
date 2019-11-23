import React, { Component } from 'react';
class Footer extends Component {
    state = {  }
    render() { 
        return ( 
            <div id="footer" class="sticky-footer">
            {/* <!--  Main  --> */ }
            <div class="container">
              <div class="row">
                <div class="col-md-5 col-sm-6">
                  <img class="footer-logo" src="images/logo.png" alt=""/>
                  <br></br>
                  <p>With MUM ApSharing. You Can list and share rooms with people across the worl. Earn Extra money.</p>
                </div>
          
                <div class="col-md-4 col-sm-6 ">
                  <h4>Helpful Links</h4>
                  <ul class="footer-links">
                    <li><a href="#">Login</a></li>
                    <li><a href="#">Sign Up</a></li>
                    <li><a href="#">My Account</a></li>
                    <li><a href="#">Add Appartment</a></li>
                    <li><a href="#">Pricing</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                  </ul>
          
                  <ul class="footer-links">
                    <li><a href="#">FAQ</a></li>
                    <li><a href="#">Blog</a></li>
                    <li><a href="#">Our Partners</a></li>
                    <li><a href="#">How It Works</a></li>
                    <li><a href="#">Contact</a></li>
                  </ul>
                  <div class="clearfix"></div>
                </div>		
          
                <div class="col-md-3  col-sm-12">
                  <h4>Contact Us</h4>
                  <div class="text-widget">
                    <span>ApSharing , Fairfiled IA</span>
                    Phone: <span>(123) 123-456 </span>
                    E-Mail:<span> <a href="#"><span class="__cf_email__" data-cfemail="167970707f757356736e777b667a733875797b">[email&#160;protected]</span></a> </span>
                  </div>
          
                  <ul class="social-icons margin-top-20">
                    <li><a class="facebook" href="#"><i class="icon-facebook"></i></a></li>
                    <li><a class="twitter" href="#"><i class="icon-twitter"></i></a></li>
                    <li><a class="gplus" href="#"><i class="icon-gplus"></i></a></li>
                    <li><a class="vimeo" href="#"><i class="icon-vimeo"></i></a></li>
                  </ul>
          
                </div>
          
              </div>
              
              {/* <!--  Copyright  --> */ }
              <div class="row">
                <div class="col-md-12">
                  <div class="copyrights">© 2019 ApSharing. All Rights Reserved.</div>
                </div>
              </div>
          
            </div>
          
          </div>

         );
    }
}
 
export default Footer;