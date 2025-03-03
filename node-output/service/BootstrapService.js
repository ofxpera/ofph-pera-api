'use strict';


/**
 * Get an OFxPERA Participant's registration information
 * API for retrieving registration information for a specific OFxPERA Participant
 *
 * participant_id String Participant identifier issued during participant registration
 * returns ParticipantConfig
 **/
exports.getParticipant = function(participant_id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = "";
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Get a list of registered OFxPERA Participants
 * API for retrieving all registered OFxPERA Participants
 *
 * returns List
 **/
exports.listParticipants = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = [ "", "" ];
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Get a list of PERA products associated with PERA Admin
 * API for retrieving all registered products associated with the PERA Admin.
 *
 * participant_id String Participant identifier issued during Participant registration
 * returns List
 **/
exports.listProductByParticipant = function(participant_id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = [ {
  "product_kiid_uri" : "product_kiid_uri",
  "product_id" : "product_id",
  "product_description" : "product_description",
  "product_name" : "product_name",
  "product_risk_rating" : "Conservative"
}, {
  "product_kiid_uri" : "product_kiid_uri",
  "product_id" : "product_id",
  "product_description" : "product_description",
  "product_name" : "product_name",
  "product_risk_rating" : "Conservative"
} ];
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Register an OFxPERA Participant
 * API for registering an OFxPERA Participant following FAPI Dynamic Client Registration requirements
 *
 * body ParticipantConfig 
 * returns ClientRegistrationResponse
 **/
exports.registerParticipant = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "registration_client_uri" : "http://example.com/aeiou",
  "client_id_issued_at" : 0,
  "registration_access_token" : "registration_access_token",
  "client_id" : "client_id"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Register a PERA Admin Product
 * API that allows PERA Admin to register a PERA product.
 *
 * returns PeraProduct
 **/
exports.registerProduct = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "product_kiid_uri" : "product_kiid_uri",
  "product_id" : "product_id",
  "product_description" : "product_description",
  "product_name" : "product_name",
  "product_risk_rating" : "Conservative"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Update an OFxPERA Participant
 * API for updating the URIs and status of an OFxPERA Participant
 *
 * body ParticipantConfig 
 * returns ClientRegistrationResponse
 **/
exports.updateParticipant = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "registration_client_uri" : "http://example.com/aeiou",
  "client_id_issued_at" : 0,
  "registration_access_token" : "registration_access_token",
  "client_id" : "client_id"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Update a PERA Admin Product
 * API that allows PERA Admin to update their product.
 *
 * product_id String Product identifier issued during product registration
 * returns PeraProduct
 **/
exports.updateProduct = function(product_id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "product_kiid_uri" : "product_kiid_uri",
  "product_id" : "product_id",
  "product_description" : "product_description",
  "product_name" : "product_name",
  "product_risk_rating" : "Conservative"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

