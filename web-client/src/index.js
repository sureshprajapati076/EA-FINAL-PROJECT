import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import { BrowserRouter as Router , Link , NavLink , Prompt } from 'react-router-dom'
import Route from  'react-router-dom/Route'


import { ApolloProvider } from 'react-apollo';
import { ApolloClient } from 'apollo-client';
import { HttpLink } from 'apollo-link-http';
import { InMemoryCache } from 'apollo-cache-inmemory';

const CATALOG_BASE_URL = 'http://localhost:8080/graphql';
const REACT_APP_CATALOG_PERSONAL_ACCESS_TOKEN = 'xcccc';
const httpLink = new HttpLink({
  uri: CATALOG_BASE_URL,
  headers: {
    authorization: `Bearer ${REACT_APP_CATALOG_PERSONAL_ACCESS_TOKEN
    }`,
  },
});

const cache = new InMemoryCache();

const client = new ApolloClient({
  link: httpLink,
  cache,
});



ReactDOM.render((
  <ApolloProvider client={client}>
    <React.Fragment>
    <App></App>
    </React.Fragment>
    </ApolloProvider>
), document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
