import firebase from "firebase/app";
import "firebase/storage";

// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyDN2fU9u6RXhUFURsKNwGxYv5xyIGZDBbw",
    authDomain: "appertment-share.firebaseapp.com",
    databaseURL: "https://appertment-share.firebaseio.com",
    projectId: "appertment-share",
    storageBucket: "appertment-share.appspot.com",
    messagingSenderId: "927922396560",
    appId: "1:927922396560:web:76fbabb7e6227d30c36715"
  };

// Initialize Firebase

firebase.initializeApp(firebaseConfig);

const storage = firebase.storage();

export { firebase, storage as default };