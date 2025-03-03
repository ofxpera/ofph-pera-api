'use strict';


/**
 * Forward customer endorsement
 *
 * endorsement String Encrypted endorsement payload in JWS/JWE format
 * returns EndorsementResponse
 **/
exports.forwardCustomerEndorsement = function(endorsement) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "endorsement_details" : {
    "sub" : "sub",
    "endorsement_date" : "2000-01-23T04:56:07.000+00:00",
    "reference_id" : "reference_id",
    "endorser_id" : "endorser_id"
  },
  "message" : "message",
  "status" : "SUCCESS",
  "timestamp" : "2000-01-23T04:56:07.000+00:00"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Get detailed customer information
 *
 * customer_id String Customer ID, this should map to the sub field returned from the OIDC token endpoint or the sub field returned from the /oauth/userinfo endpoint
 * returns CustomerInformation
 **/
exports.getCustomerDetail = function(customer_id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "arrangementId" : "arrangementId",
  "sub" : "sub",
  "cdd" : {
    "pepIndicator" : false,
    "occupation" : "occupation",
    "employerAddress" : {
      "street_address" : "street_address",
      "country" : "PHL",
      "province" : "province",
      "city" : "city",
      "region" : "region",
      "postal_code" : "postal_code",
      "barangay" : "barangay"
    },
    "natureOfWork" : "natureOfWork",
    "cddIndicator" : "Normal",
    "employerName" : "employerName",
    "employmentStatus" : "employmentStatus",
    "fundSource" : "fundSource"
  },
  "presentedIds" : [ {
    "idType" : "idType",
    "idExpiryDate" : "2000-01-23",
    "idNumber" : "idNumber"
  }, {
    "idType" : "idType",
    "idExpiryDate" : "2000-01-23",
    "idNumber" : "idNumber"
  } ],
  "personalInformation" : {
    "sub" : "sub",
    "lastName" : "lastName",
    "phoneNumber" : "63287654321",
    "birthdate" : "2000-01-23",
    "nationality" : "nationality",
    "mobileNumber" : "639171234567",
    "givenName" : "givenName",
    "tin" : "tin",
    "middleName" : "middleName",
    "title" : "title",
    "suffix" : "suffix",
    "email" : ""
  },
  "peraAdmin" : "peraAdmin"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

