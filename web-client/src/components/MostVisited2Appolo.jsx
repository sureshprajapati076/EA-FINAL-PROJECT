import React, { Component } from "react";
import axios from 'axios'

import gql from 'graphql-tag';
import { Query } from 'react-apollo';

const GET_CURRENT_USER = gql`
{
  vehicles(count: 1) 
  {
    id, 
    type, 
    modelCode
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

export default function MostVisited() {
  return (
    <Query query={GET_CURRENT_BOOK}>
      {({ loading, error, data }) => {
        if (loading) return "Loading...";
        if (error) return `Error! ${error.message}`;

        return (
          <div className="characters">
            {data.bookById.id}
            {/* {data.characters.results.map(character => (
              <div key={character.name} className="character">
                <img src={character.image} alt={character.name} />
                <p>{character.name}</p>
              </div>
            ))} */}
          </div>
        );
      }}
    </Query>
  );
}