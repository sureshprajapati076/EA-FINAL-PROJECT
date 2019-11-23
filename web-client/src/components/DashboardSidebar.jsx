import React, { Component } from 'react';
class DashboardSidebar extends Component {
    state = {  }
    render() { 
        return ( 
            <div class="dashboard-nav">
            <div class="dashboard-nav-inner">
    
                <ul data-submenu-title="Main">
                    <li><a href="dashboard.html"><i class="sl sl-icon-settings"></i> Dashboard</a></li>
                    <li><a href="/messages"><i class="sl sl-icon-envelope-open"></i> Messages <span class="nav-tag messages">2</span></a></li>
                    <li><a href="/bookings"><i class="fa fa-calendar-check-o"></i> Bookings</a></li>
                    <li><a href="/payments"><i class="sl sl-icon-wallet"></i> Wallet</a></li>
                </ul>
                
                <ul data-submenu-title="Listings">
                    <li><a href="/listings"><i class="sl sl-icon-layers"></i> My Listings</a>	
                    </li>
                    <li><a href="/reviews"><i class="sl sl-icon-star"></i> Reviews</a></li>
                   
                    <li class="active"><a href="addlist"><i class="sl sl-icon-plus"></i> Add Listing</a></li>
                </ul>	
    
                <ul data-submenu-title="Account">
                    <li><a href="/profile"><i class="sl sl-icon-user"></i> My Profile</a></li>
                    <li><a href="/logout"><i class="sl sl-icon-power"></i> Logout</a></li>
                </ul>
    
            </div>
        </div>
          );
    }
}
 
export default DashboardSidebar;