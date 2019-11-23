import React, { Component } from "react";
import { BrowserRouter as Router , Link , NavLink , Prompt } from 'react-router-dom';
class ListAppartments extends Component {
  state = {};
  render() {
    console.log(this.props.results);
    return (
      <div class="container">
        <div class="row">
          <h3>Showing Search Results for {this.props.searchQuery}</h3>

          <div class="row">
            {this.props.results.map(appartment => (
              <div class="col-lg-12 col-md-12">
                <div class="listing-item-container list-layout">
                  <NavLink to="/single" class="listing-item">
                    {/* <!--  Image  --> */}
                    <div class="listing-item-image">
                      <img src={appartment.imageUrl} alt="" />
                      <span class="tag">New</span>
                    </div>

                    {/* <!--  Content  --> */}
                    <div class="listing-item-content">
                      <div class="listing-badge now-open">Now Open</div>

                      <div class="listing-item-inner">
                        <h3>
                          {appartment.title} <i class="verified-icon"></i>
                        </h3>
                        <span>{appartment.details}</span>
                        <div class="star-rating" data-rating="3.5">
                          <div class="rating-counter">(12 reviews)</div>
                        </div>
                      </div>

                      <span class="like-icon"></span>
                    </div>
                  </NavLink>
                </div>
              </div>
            ))}
            {/* <!--  Listing Item / End  --> */}


          </div>

          {/* <!--  Pagination  --> */}
          <div class="clearfix"></div>
          <div class="row">
            <div class="col-md-12">
              {/* <!--  Pagination  --> */}
              <div class="pagination-container margin-top-20 margin-bottom-40">
                <nav class="pagination">
                  <ul>
                    <li>
                      <a href="#" class="current-page">
                        1
                      </a>
                    </li>
                    <li>
                      <a href="#">2</a>
                    </li>
                    <li>
                      <a href="#">3</a>
                    </li>
                    <li>
                      <a href="#">
                        <i class="sl sl-icon-arrow-right"></i>
                      </a>
                    </li>
                  </ul>
                </nav>
              </div>
            </div>
          </div>
          {/* <!--  Pagination / End  --> */}
        </div>
      </div>
    );
  }
}

export default ListAppartments;
