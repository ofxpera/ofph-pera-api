'use strict';


/**
 * Get the status of a PERA arrangement
 * API that allows FIs to retrieve the status of one or more PERA Arrangements
 *
 * arrangement_id String The ID of the PERA Arrangement
 * returns PeraArrangement
 **/
exports.getArrangementStatus = function(arrangement_id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "sub" : "sub",
  "admin_id" : "admin_id",
  "id" : "id",
  "creation_date" : "2000-01-23T04:56:07.000+00:00",
  "customer_id" : "customer_id",
  "consent_id" : "consent_id",
  "account" : {
    "product" : {
      "product_kiid_uri" : "product_kiid_uri",
      "product_id" : "product_id",
      "product_description" : "product_description",
      "product_name" : "product_name",
      "product_risk_rating" : "Conservative"
    },
    "balance" : {
      "as_of" : "2000-01-23T04:56:07.000+00:00",
      "currency" : "PHP",
      "current_value" : 0.8008281904610115
    },
    "id" : "id",
    "creation_date" : "2000-01-23T04:56:07.000+00:00",
    "customer_id" : "customer_id"
  },
  "status" : "ACTIVE"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Registers a new PERA arrangement
 * API that allows PERA Admins to register the successful creation of one or more new PERA Arrangements
 *
 * returns PeraArrangement
 **/
exports.peraArrangementRegistration = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "sub" : "sub",
  "admin_id" : "admin_id",
  "id" : "id",
  "creation_date" : "2000-01-23T04:56:07.000+00:00",
  "customer_id" : "customer_id",
  "consent_id" : "consent_id",
  "account" : {
    "product" : {
      "product_kiid_uri" : "product_kiid_uri",
      "product_id" : "product_id",
      "product_description" : "product_description",
      "product_name" : "product_name",
      "product_risk_rating" : "Conservative"
    },
    "balance" : {
      "as_of" : "2000-01-23T04:56:07.000+00:00",
      "currency" : "PHP",
      "current_value" : 0.8008281904610115
    },
    "id" : "id",
    "creation_date" : "2000-01-23T04:56:07.000+00:00",
    "customer_id" : "customer_id"
  },
  "status" : "ACTIVE"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

