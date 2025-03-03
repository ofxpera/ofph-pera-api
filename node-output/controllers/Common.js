'use strict';

var utils = require('../utils/writer.js');
var Common = require('../service/CommonService');

module.exports.forwardCustomerEndorsement = function forwardCustomerEndorsement (req, res, next, endorsement) {
  Common.forwardCustomerEndorsement(endorsement)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getCustomerDetail = function getCustomerDetail (req, res, next, customer_id) {
  Common.getCustomerDetail(customer_id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
