### How to run it?
We have deployed this project on google cloud and exposed some external IPS to make request to and from.
### Installation

### Run front end (React)
```sh
$ cd web-client #This is folder for front end
$ npm install
$ npm start #after this it will open browser with our home page.
```


### Testing Using PostMan / RestClient Apps
This requires PostMan / RestClient installed on your machine.
Following is sample for testing our api using RestClient for Visual Studio.



POST http://34.70.251.216/signup

content-type: application/json



    {
    "email":"sureshprajapati@gmail.com",

    "password":"admin",

    "name":"Admin",

    "prefferedPayment":"CC",

    "address":"UTOPIA",

    "roles":["ADMIN","USER"]
    }





###

POST http://34.70.251.216/signin

content-type: application/json


	{
	"username":"sureshprajapati@gmail.com",
    "password":"admin"
	}

### You will get JWT token from above login use this token for your request to authenticate the user

GET http://34.70.251.216/viewauthorizedpage

content-type: application/json

Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbnlAZ21haWwuY29tIi
wiZXhwIjoxNTc0MzQyMjE0LCJpYXQiOjE1NzQzMjQyMTR9.boQhQP
A2ccbbeII-7FksgWrcm2f8SB2Yk9tdQ0ZYa8sxwt2FVJXK_bKss
b5jdenkABMXJzu7Chhumns9qrbgqQ


### ADD Comment   This is for local mode, adding comment and replies

POST http://localhost:7809/add

content-type: application/json

	{
  	"id":"6",
  	"apartmentId":"3",
  	"emailId":"suresh@gmail.com",
  	"comment":"some comments",
  	"stars":"43"
	}

### READ ALL COMMENTS

GET http://localhost:7809/getall

content-type: application/json



### Get Comment for particular apartment with id 1

GET http://localhost:7809/find/1

content-type: application/json


### Replying to comment id 5

POST http://localhost:7809/reply/5

content-type: application/json


	{
    	"comment":"really wonderful",
    	"email":"someoneelse@gmail.com"
	}

### Adding new apartments


POST http://35.222.201.234/saveapartment

content-type: application/json


	{
  	"apartmentId": "11",
 	 "apartmentTitle": "title3",
 	 "category": "C2",
 	 "unitNumber": "UNIT1",
  	"apartmentImages": "url",
 	 "apartmentDescription": "description1",
 	 "apartmentPhoneNumber": "2220000",
	  "apartmentWebsite": "www.sth.com",
 	"apartmentEmail": "gmail.com",
 	 "apartmentCostDescription": "description",
 	 "apartmentCost": "22.34",
  	"apartmentKeyword": "good",
  	"apartmentLocationCity": "city",
  	"apartmentLocationStreet": "street",
  	"apartmentLocationState": "WA",
 	 "apartmentLocationZipCode": "22222"
	}
###

GET http://35.222.201.234/displayApt/11



### Book an apartment using jwt token you will get email notification after submission

POST  http://35.222.201.234/book

content-type: application/json

Authorization: Bearer yJhbGciOiJIUzUxMiJ9.eyJzdWIiO
iJ5Z2hpbWlyZTE5OTRAZ21haWwuY29tIiwiZXhwIjoxNTc0Mzc2N
zY1LCJpYXQiOjE1NzQzNTg3NjV9.tqlRI1eExRPAvfHRH7PGhU8UvizkA3
gzRPOKQMZdns_4C0T4Z8dQ7wPxbX_WKkhfSoNmzSZEoZZNlegp1wX-uQ

	{
    	"id":"12",
   	 "apt_id":"11",
  	  "unit_number":"C2",
  	  "unit_price":"3.5",
 	   "start_date":"2019-11-15",
  	  "end_date":"2019-11-30"
	}


Group Members
----------------------------
- Brian Bwengye (610158)
- Sagar Ghimire (610104)
- Sunena Gwachha (109578)
- Suresh Prajapati (109524)
- Yubraj Ghimire (610143)


