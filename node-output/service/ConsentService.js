'use strict';


/**
 * Bulk update customer's consent arrangements
 * Update multiple consent arrangements for a specific customer in a single request. Based on: - Australia CDR Bulk Consumer Update - Korea MyData Consent Management 
 *
 * body Arrangements_bulkupdate_body 
 * customer_id String The customer's unique identifier
 * returns inline_response_200_6
 **/
exports.bulkUpdateCustomerConsents = function(body,customer_id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "customer_id" : "customer_id",
  "results" : [ {
    "id" : "id",
    "error" : {
      "code" : "code",
      "message" : "message"
    },
    "status" : "success"
  }, {
    "id" : "id",
    "error" : {
      "code" : "code",
      "message" : "message"
    },
    "status" : "success"
  } ]
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Create bulk consent arrangements
 * Create multiple consent arrangements in a single request. Based on: - Korea MyData Bulk Consent API - Singapore SGFinDex Multi-Institution Consent 
 *
 * body BulkConsentRequest 
 * returns BulkConsentResponse
 **/
exports.createBulkConsent = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "batch_id" : "batch_id",
  "results" : [ {
    "arrangement" : {
      "data_holder_id" : "data_holder_id",
      "sharing_duration" : {
        "end_date" : "2000-01-23T04:56:07.000+00:00",
        "start_date" : "2000-01-23T04:56:07.000+00:00"
      },
      "purpose" : "purpose",
      "last_updated_at" : "2000-01-23T04:56:07.000+00:00",
      "permissions" : [ "permissions", "permissions" ],
      "revocation_info" : {
        "reason" : "reason",
        "revoked_at" : "2000-01-23T04:56:07.000+00:00"
      },
      "additional_terms" : [ {
        "value" : "value",
        "key" : "key"
      }, {
        "value" : "value",
        "key" : "key"
      } ],
      "created_at" : "2000-01-23T04:56:07.000+00:00",
      "id" : "id",
      "status" : "active"
    },
    "error" : {
      "code" : "code",
      "message" : "message"
    },
    "status" : "success"
  }, {
    "arrangement" : {
      "data_holder_id" : "data_holder_id",
      "sharing_duration" : {
        "end_date" : "2000-01-23T04:56:07.000+00:00",
        "start_date" : "2000-01-23T04:56:07.000+00:00"
      },
      "purpose" : "purpose",
      "last_updated_at" : "2000-01-23T04:56:07.000+00:00",
      "permissions" : [ "permissions", "permissions" ],
      "revocation_info" : {
        "reason" : "reason",
        "revoked_at" : "2000-01-23T04:56:07.000+00:00"
      },
      "additional_terms" : [ {
        "value" : "value",
        "key" : "key"
      }, {
        "value" : "value",
        "key" : "key"
      } ],
      "created_at" : "2000-01-23T04:56:07.000+00:00",
      "id" : "id",
      "status" : "active"
    },
    "error" : {
      "code" : "code",
      "message" : "message"
    },
    "status" : "success"
  } ]
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Create a consent arrangement
 * Create a new consent arrangement between a data holder and data recipient. Based on: - UK Open Banking Consent API v3.1.10 - Australia CDR Consent Management Standards v1.14.0 - Singapore SGFinDex Consent Framework 
 *
 * body ConsentArrangementRequest 
 * returns ConsentArrangementResponse
 **/
exports.createConsentArrangement = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "data_holder_id" : "data_holder_id",
  "sharing_duration" : {
    "end_date" : "2000-01-23T04:56:07.000+00:00",
    "start_date" : "2000-01-23T04:56:07.000+00:00"
  },
  "purpose" : "purpose",
  "last_updated_at" : "2000-01-23T04:56:07.000+00:00",
  "permissions" : [ "permissions", "permissions" ],
  "revocation_info" : {
    "reason" : "reason",
    "revoked_at" : "2000-01-23T04:56:07.000+00:00"
  },
  "additional_terms" : [ {
    "value" : "value",
    "key" : "key"
  }, {
    "value" : "value",
    "key" : "key"
  } ],
  "created_at" : "2000-01-23T04:56:07.000+00:00",
  "id" : "id",
  "status" : "active"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Extend consent arrangement duration
 * Extend the duration of an existing consent arrangement. Based on: - Australia CDR Consent Amendment - UK Open Banking Re-authentication 
 *
 * body ConsentExtensionRequest 
 * arrangement_id String The ID of the consent arrangement
 * returns ConsentArrangementResponse
 **/
exports.extendConsentDuration = function(body,arrangement_id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "data_holder_id" : "data_holder_id",
  "sharing_duration" : {
    "end_date" : "2000-01-23T04:56:07.000+00:00",
    "start_date" : "2000-01-23T04:56:07.000+00:00"
  },
  "purpose" : "purpose",
  "last_updated_at" : "2000-01-23T04:56:07.000+00:00",
  "permissions" : [ "permissions", "permissions" ],
  "revocation_info" : {
    "reason" : "reason",
    "revoked_at" : "2000-01-23T04:56:07.000+00:00"
  },
  "additional_terms" : [ {
    "value" : "value",
    "key" : "key"
  }, {
    "value" : "value",
    "key" : "key"
  } ],
  "created_at" : "2000-01-23T04:56:07.000+00:00",
  "id" : "id",
  "status" : "active"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Get consent arrangement details
 * Retrieve details of a specific consent arrangement. Based on: - UK Open Banking Account Access Consents API - Australia CDR Get Consent API 
 *
 * arrangement_id String The ID of the consent arrangement
 * returns ConsentArrangementResponse
 **/
exports.getConsentArrangement = function(arrangement_id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "data_holder_id" : "data_holder_id",
  "sharing_duration" : {
    "end_date" : "2000-01-23T04:56:07.000+00:00",
    "start_date" : "2000-01-23T04:56:07.000+00:00"
  },
  "purpose" : "purpose",
  "last_updated_at" : "2000-01-23T04:56:07.000+00:00",
  "permissions" : [ "permissions", "permissions" ],
  "revocation_info" : {
    "reason" : "reason",
    "revoked_at" : "2000-01-23T04:56:07.000+00:00"
  },
  "additional_terms" : [ {
    "value" : "value",
    "key" : "key"
  }, {
    "value" : "value",
    "key" : "key"
  } ],
  "created_at" : "2000-01-23T04:56:07.000+00:00",
  "id" : "id",
  "status" : "active"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Get consent arrangement history
 * Retrieve the full history of changes to a consent arrangement. Based on: - Australia CDR Consent History API - UK Open Banking Consent Audit Requirements 
 *
 * arrangement_id String The ID of the consent arrangement
 * returns ConsentHistory
 **/
exports.getConsentHistory = function(arrangement_id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "id" : "id",
  "events" : [ {
    "actor" : "actor",
    "event_type" : "created",
    "previous_state" : { },
    "new_state" : { },
    "details" : { },
    "timestamp" : "2000-01-23T04:56:07.000+00:00"
  }, {
    "actor" : "actor",
    "event_type" : "created",
    "previous_state" : { },
    "new_state" : { },
    "details" : { },
    "timestamp" : "2000-01-23T04:56:07.000+00:00"
  } ]
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Get customer's consent dashboard
 * Retrieve a comprehensive view of customer's consent arrangements and data sharing. Based on: - Australia CDR Consumer Dashboard - UK Open Banking Consent Dashboard - Singapore SGFinDex Customer Portal 
 *
 * customer_id String The customer's unique identifier
 * returns ConsentDashboard
 **/
exports.getCustomerConsentDashboard = function(customer_id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "summary" : {
    "expiring_soon" : [ {
      "data_holder_id" : "data_holder_id",
      "sharing_duration" : {
        "end_date" : "2000-01-23T04:56:07.000+00:00",
        "start_date" : "2000-01-23T04:56:07.000+00:00"
      },
      "purpose" : "purpose",
      "last_updated_at" : "2000-01-23T04:56:07.000+00:00",
      "permissions" : [ "permissions", "permissions" ],
      "revocation_info" : {
        "reason" : "reason",
        "revoked_at" : "2000-01-23T04:56:07.000+00:00"
      },
      "additional_terms" : [ {
        "value" : "value",
        "key" : "key"
      }, {
        "value" : "value",
        "key" : "key"
      } ],
      "created_at" : "2000-01-23T04:56:07.000+00:00",
      "id" : "id",
      "status" : "active"
    }, {
      "data_holder_id" : "data_holder_id",
      "sharing_duration" : {
        "end_date" : "2000-01-23T04:56:07.000+00:00",
        "start_date" : "2000-01-23T04:56:07.000+00:00"
      },
      "purpose" : "purpose",
      "last_updated_at" : "2000-01-23T04:56:07.000+00:00",
      "permissions" : [ "permissions", "permissions" ],
      "revocation_info" : {
        "reason" : "reason",
        "revoked_at" : "2000-01-23T04:56:07.000+00:00"
      },
      "additional_terms" : [ {
        "value" : "value",
        "key" : "key"
      }, {
        "value" : "value",
        "key" : "key"
      } ],
      "created_at" : "2000-01-23T04:56:07.000+00:00",
      "id" : "id",
      "status" : "active"
    } ],
    "arrangements_by_status" : {
      "expired" : 5,
      "active" : 1,
      "revoked" : 5,
      "suspended" : 2
    },
    "arrangements_by_purpose" : [ {
      "purpose" : "purpose",
      "count" : 7
    }, {
      "purpose" : "purpose",
      "count" : 7
    } ],
    "data_holders" : [ {
      "data_holder_id" : "data_holder_id",
      "name" : "name",
      "active_arrangements" : 9
    }, {
      "data_holder_id" : "data_holder_id",
      "name" : "name",
      "active_arrangements" : 9
    } ],
    "total_arrangements" : 0,
    "recent_activity" : [ {
      "id" : "id",
      "events" : [ {
        "actor" : "actor",
        "event_type" : "created",
        "previous_state" : { },
        "new_state" : { },
        "details" : { },
        "timestamp" : "2000-01-23T04:56:07.000+00:00"
      }, {
        "actor" : "actor",
        "event_type" : "created",
        "previous_state" : { },
        "new_state" : { },
        "details" : { },
        "timestamp" : "2000-01-23T04:56:07.000+00:00"
      } ]
    }, {
      "id" : "id",
      "events" : [ {
        "actor" : "actor",
        "event_type" : "created",
        "previous_state" : { },
        "new_state" : { },
        "details" : { },
        "timestamp" : "2000-01-23T04:56:07.000+00:00"
      }, {
        "actor" : "actor",
        "event_type" : "created",
        "previous_state" : { },
        "new_state" : { },
        "details" : { },
        "timestamp" : "2000-01-23T04:56:07.000+00:00"
      } ]
    } ],
    "active_arrangements" : 6
  },
  "customer_id" : "customer_id"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Get customer's consent arrangements
 * Retrieve all consent arrangements for a specific customer. Based on: - UK Open Banking Customer Consent Management - Australia CDR Consumer Dashboard APIs - Singapore SGFinDex Customer Consent View 
 *
 * customer_id String The customer's unique identifier
 * status String Filter consents by status (optional)
 * data_holder_id String Filter by specific data holder/institution (optional)
 * purpose String Filter by consent purpose (optional)
 * returns inline_response_200_5
 **/
exports.getCustomerConsents = function(customer_id,status,data_holder_id,purpose) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "total_arrangements" : 0,
  "customer_id" : "customer_id",
  "active_arrangements" : 6,
  "arrangements" : [ {
    "data_holder_id" : "data_holder_id",
    "sharing_duration" : {
      "end_date" : "2000-01-23T04:56:07.000+00:00",
      "start_date" : "2000-01-23T04:56:07.000+00:00"
    },
    "purpose" : "purpose",
    "last_updated_at" : "2000-01-23T04:56:07.000+00:00",
    "permissions" : [ "permissions", "permissions" ],
    "revocation_info" : {
      "reason" : "reason",
      "revoked_at" : "2000-01-23T04:56:07.000+00:00"
    },
    "additional_terms" : [ {
      "value" : "value",
      "key" : "key"
    }, {
      "value" : "value",
      "key" : "key"
    } ],
    "created_at" : "2000-01-23T04:56:07.000+00:00",
    "id" : "id",
    "status" : "active"
  }, {
    "data_holder_id" : "data_holder_id",
    "sharing_duration" : {
      "end_date" : "2000-01-23T04:56:07.000+00:00",
      "start_date" : "2000-01-23T04:56:07.000+00:00"
    },
    "purpose" : "purpose",
    "last_updated_at" : "2000-01-23T04:56:07.000+00:00",
    "permissions" : [ "permissions", "permissions" ],
    "revocation_info" : {
      "reason" : "reason",
      "revoked_at" : "2000-01-23T04:56:07.000+00:00"
    },
    "additional_terms" : [ {
      "value" : "value",
      "key" : "key"
    }, {
      "value" : "value",
      "key" : "key"
    } ],
    "created_at" : "2000-01-23T04:56:07.000+00:00",
    "id" : "id",
    "status" : "active"
  } ]
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * List consent arrangements
 * Retrieve a list of active consent arrangements for the authenticated user. Based on: - UK Open Banking Account Access Consents API - Australia CDR Get Consent API 
 *
 * status String Filter consents by status (optional)
 * from_date Date Filter consents created after this date (optional)
 * to_date Date Filter consents created before this date (optional)
 * returns List
 **/
exports.listConsentArrangements = function(status,from_date,to_date) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = [ {
  "data_holder_id" : "data_holder_id",
  "sharing_duration" : {
    "end_date" : "2000-01-23T04:56:07.000+00:00",
    "start_date" : "2000-01-23T04:56:07.000+00:00"
  },
  "purpose" : "purpose",
  "last_updated_at" : "2000-01-23T04:56:07.000+00:00",
  "permissions" : [ "permissions", "permissions" ],
  "revocation_info" : {
    "reason" : "reason",
    "revoked_at" : "2000-01-23T04:56:07.000+00:00"
  },
  "additional_terms" : [ {
    "value" : "value",
    "key" : "key"
  }, {
    "value" : "value",
    "key" : "key"
  } ],
  "created_at" : "2000-01-23T04:56:07.000+00:00",
  "id" : "id",
  "status" : "active"
}, {
  "data_holder_id" : "data_holder_id",
  "sharing_duration" : {
    "end_date" : "2000-01-23T04:56:07.000+00:00",
    "start_date" : "2000-01-23T04:56:07.000+00:00"
  },
  "purpose" : "purpose",
  "last_updated_at" : "2000-01-23T04:56:07.000+00:00",
  "permissions" : [ "permissions", "permissions" ],
  "revocation_info" : {
    "reason" : "reason",
    "revoked_at" : "2000-01-23T04:56:07.000+00:00"
  },
  "additional_terms" : [ {
    "value" : "value",
    "key" : "key"
  }, {
    "value" : "value",
    "key" : "key"
  } ],
  "created_at" : "2000-01-23T04:56:07.000+00:00",
  "id" : "id",
  "status" : "active"
} ];
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * List available consent templates
 * Retrieve available consent templates that can be used to create new arrangements. Based on: - Australia CDR Consent Taxonomy - UK Open Banking Standard Permissions 
 *
 * category String Filter templates by category (optional)
 * purpose String Filter templates by purpose (optional)
 * returns List
 **/
exports.listConsentTemplates = function(category,purpose) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = [ {
  "terms_and_conditions" : "terms_and_conditions",
  "purpose" : "purpose",
  "permissions" : [ "permissions", "permissions" ],
  "data_usage_policy" : "data_usage_policy",
  "name" : "name",
  "description" : "description",
  "template_id" : "template_id",
  "category" : "category",
  "version" : "version",
  "default_duration" : {
    "unit" : "days",
    "value" : 0
  }
}, {
  "terms_and_conditions" : "terms_and_conditions",
  "purpose" : "purpose",
  "permissions" : [ "permissions", "permissions" ],
  "data_usage_policy" : "data_usage_policy",
  "name" : "name",
  "description" : "description",
  "template_id" : "template_id",
  "category" : "category",
  "version" : "version",
  "default_duration" : {
    "unit" : "days",
    "value" : 0
  }
} ];
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Revoke consent arrangement
 * Revoke an existing consent arrangement. Based on: - UK Open Banking Account Access Consents API - Australia CDR Revoke Consent API - Korea MyData Consent Revocation API 
 *
 * arrangement_id String The ID of the consent arrangement to revoke
 * no response value expected for this operation
 **/
exports.revokeConsentArrangement = function(arrangement_id) {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Update consent arrangement status
 * Update the status of a consent arrangement (e.g., suspend, resume). Based on: - UK Open Banking Account Access Consents API - Australia CDR Update Consent API 
 *
 * body ConsentStatusUpdate 
 * arrangement_id String The ID of the consent arrangement
 * returns ConsentArrangementResponse
 **/
exports.updateConsentStatus = function(body,arrangement_id) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "data_holder_id" : "data_holder_id",
  "sharing_duration" : {
    "end_date" : "2000-01-23T04:56:07.000+00:00",
    "start_date" : "2000-01-23T04:56:07.000+00:00"
  },
  "purpose" : "purpose",
  "last_updated_at" : "2000-01-23T04:56:07.000+00:00",
  "permissions" : [ "permissions", "permissions" ],
  "revocation_info" : {
    "reason" : "reason",
    "revoked_at" : "2000-01-23T04:56:07.000+00:00"
  },
  "additional_terms" : [ {
    "value" : "value",
    "key" : "key"
  }, {
    "value" : "value",
    "key" : "key"
  } ],
  "created_at" : "2000-01-23T04:56:07.000+00:00",
  "id" : "id",
  "status" : "active"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

