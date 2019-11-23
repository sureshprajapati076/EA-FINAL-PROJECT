import React, { Component } from "react";
import axios from 'axios';
import { BrowserRouter as Router , Link , NavLink , Prompt } from 'react-router-dom';

import gql from 'graphql-tag';
import { Query } from 'react-apollo';

const GET_APARTMENTS = gql`
{
  apartments(count: 1) 
  {
    id, 
    title, 
    details,
    imageUrl
}
}
`;

const GET_CURRENT_BOOK = gql`
{
  bookById(id: "book-1") 
  {
    id, 
    name, 
    pageCount,
    author{
      firstName,
      lastName
    }
}
}
`;


class MostVisted extends Component {

  state = {
    apartments:["brian","bwenge"]
  };

  componentDidMount() {
    axios({
      url: "http://localhost:8080/graphql",
      method: "post",
      data: {
        query: `
          query {
            apartments(count: 3) 
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
    return (
      <section
        class="fullwidth margin-top-65 padding-top-75 padding-bottom-70"
        data-background-color="#f8f8f8"
      >
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <h3 class="headline centered margin-bottom-45">
                <strong class="headline-with-separator">
                  Most Visited Places
                </strong>
                <span>Discover Top-Rated Apartments</span>
              </h3>
            </div>

            <div class="col-md-12">
              <div class="simple-slick-carousel dots-nav">

                {/* <!--  Listing Item  --> */}
                {apartments.map(apartment=>
                

              

                <div class="carousel-item">
                  <NavLink to="/single"
                   
                    class="listing-item-container"
                  >
                    <div class="listing-item">
                      <img src={apartment.imageUrl} alt="" />

                      <div class="listing-badge now-open">Now Open</div>

                      <div class="listing-item-content">
                        <span class="tag">Eat and Drink</span>
                        <h3>
                          {apartment.title} <i class="verified-icon"></i>
                        </h3>
                <span>{apartment.details}</span>
                      </div>
                      <span class="like-icon"></span>
                    </div>
                    <div class="star-rating" data-rating="3.5">
                      <div class="rating-counter">(12 reviews)</div>
                    </div>
                  </NavLink>
                </div>

                )}  
                {/* <!--  Listing Item / End  --> */}

              </div>
            </div>
          </div>
        </div>
      </section>
    );
  }
}

export default MostVisted;
