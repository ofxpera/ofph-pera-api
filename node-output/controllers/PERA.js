'use strict';

var utils = require('../utils/writer.js');
var PERA = require('../service/PERAService');

module.exports.getArrangementStatus = function getArrangementStatus (req, res, next, arrangement_id) {
  PERA.getArrangementStatus(arrangement_id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.peraArrangementRegistration = function peraArrangementRegistration (req, res, next) {
  PERA.peraArrangementRegistration()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
