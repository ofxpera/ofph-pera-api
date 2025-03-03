'use strict';

var utils = require('../utils/writer.js');
var Consent = require('../service/ConsentService');

module.exports.bulkUpdateCustomerConsents = function bulkUpdateCustomerConsents (req, res, next, body, customer_id) {
  Consent.bulkUpdateCustomerConsents(body, customer_id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.createBulkConsent = function createBulkConsent (req, res, next, body) {
  Consent.createBulkConsent(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.createConsentArrangement = function createConsentArrangement (req, res, next, body) {
  Consent.createConsentArrangement(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.extendConsentDuration = function extendConsentDuration (req, res, next, body, arrangement_id) {
  Consent.extendConsentDuration(body, arrangement_id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getConsentArrangement = function getConsentArrangement (req, res, next, arrangement_id) {
  Consent.getConsentArrangement(arrangement_id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getConsentHistory = function getConsentHistory (req, res, next, arrangement_id) {
  Consent.getConsentHistory(arrangement_id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getCustomerConsentDashboard = function getCustomerConsentDashboard (req, res, next, customer_id) {
  Consent.getCustomerConsentDashboard(customer_id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getCustomerConsents = function getCustomerConsents (req, res, next, customer_id, status, data_holder_id, purpose) {
  Consent.getCustomerConsents(customer_id, status, data_holder_id, purpose)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.listConsentArrangements = function listConsentArrangements (req, res, next, status, from_date, to_date) {
  Consent.listConsentArrangements(status, from_date, to_date)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.listConsentTemplates = function listConsentTemplates (req, res, next, category, purpose) {
  Consent.listConsentTemplates(category, purpose)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.revokeConsentArrangement = function revokeConsentArrangement (req, res, next, arrangement_id) {
  Consent.revokeConsentArrangement(arrangement_id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.updateConsentStatus = function updateConsentStatus (req, res, next, body, arrangement_id) {
  Consent.updateConsentStatus(body, arrangement_id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
