/**
 * OFxPERA API
 * Philippines Open Finance API Implementation for PERA
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This file is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the file manually.
 */

import * as api from "./api"
import { Configuration } from "./configuration"

const config: Configuration = {}

describe("BootstrapApi", () => {
  let instance: api.BootstrapApi
  beforeEach(function() {
    instance = new api.BootstrapApi(config)
  });

  test("getParticipant", () => {
    const participantId: string = "participantId_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.getParticipant(participantId, participantId, xV, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("listParticipants", () => {
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.listParticipants(participantId, xV, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("listProductByParticipant", () => {
    const participantId: string = "participantId_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.listProductByParticipant(participantId, participantId, xV, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("registerParticipant", () => {
    const body: api.ParticipantConfig = undefined
    const xV: number = 56
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.registerParticipant(body, xV, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("registerProduct", () => {
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.registerProduct(participantId, xV, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("updateParticipant", () => {
    const body: api.ParticipantConfig = undefined
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.updateParticipant(body, participantId, xV, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("updateProduct", () => {
    const productId: string = "productId_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.updateProduct(productId, participantId, xV, xFapiInteractionId, {})).resolves.toBe(null)
  })
})

describe("CommonApi", () => {
  let instance: api.CommonApi
  beforeEach(function() {
    instance = new api.CommonApi(config)
  });

  test("forwardCustomerEndorsement", () => {
    const endorsement: string = "endorsement_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.forwardCustomerEndorsement(endorsement, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("getCustomerDetail", () => {
    const customerId: string = "customerId_example"
    const authorization: string = "authorization_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.getCustomerDetail(customerId, authorization, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId, {})).resolves.toBe(null)
  })
})

describe("ConsentApi", () => {
  let instance: api.ConsentApi
  beforeEach(function() {
    instance = new api.ConsentApi(config)
  });

  test("bulkUpdateCustomerConsents", () => {
    const body: api.ArrangementsBulkupdateBody = undefined
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const customerId: string = "customerId_example"
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.bulkUpdateCustomerConsents(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, customerId, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("createBulkConsent", () => {
    const body: api.BulkConsentRequest = undefined
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.createBulkConsent(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("createConsentArrangement", () => {
    const body: api.ConsentArrangementRequest = undefined
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.createConsentArrangement(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("extendConsentDuration", () => {
    const body: api.ConsentExtensionRequest = undefined
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const arrangementId: string = "arrangementId_example"
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.extendConsentDuration(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, arrangementId, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("getConsentArrangement", () => {
    const arrangementId: string = "arrangementId_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.getConsentArrangement(arrangementId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("getConsentHistory", () => {
    const arrangementId: string = "arrangementId_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.getConsentHistory(arrangementId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("getCustomerConsentDashboard", () => {
    const customerId: string = "customerId_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.getCustomerConsentDashboard(customerId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("getCustomerConsents", () => {
    const customerId: string = "customerId_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const status: string = "status_example"
    const dataHolderId: string = "dataHolderId_example"
    const purpose: string = "purpose_example"
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.getCustomerConsents(customerId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, status, dataHolderId, purpose, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("listConsentArrangements", () => {
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const status: string = "status_example"
    const fromDate: Date = 2013-10-20T19:20:30+01:00
    const toDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.listConsentArrangements(participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, status, fromDate, toDate, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("listConsentTemplates", () => {
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const category: string = "category_example"
    const purpose: string = "purpose_example"
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.listConsentTemplates(participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, category, purpose, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("revokeConsentArrangement", () => {
    const arrangementId: string = "arrangementId_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.revokeConsentArrangement(arrangementId, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("updateConsentStatus", () => {
    const body: api.ConsentStatusUpdate = undefined
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const arrangementId: string = "arrangementId_example"
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.updateConsentStatus(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, arrangementId, xFapiInteractionId, {})).resolves.toBe(null)
  })
})

describe("DiscoveryApi", () => {
  let instance: api.DiscoveryApi
  beforeEach(function() {
    instance = new api.DiscoveryApi(config)
  });

  test("deleteClientRegistration", () => {
    return expect(instance.deleteClientRegistration({})).resolves.toBe(null)
  })
  test("getClientRegistration", () => {
    return expect(instance.getClientRegistration({})).resolves.toBe(null)
  })
  test("getJwks", () => {
    return expect(instance.getJwks({})).resolves.toBe(null)
  })
  test("getOpenIdConfiguration", () => {
    return expect(instance.getOpenIdConfiguration({})).resolves.toBe(null)
  })
  test("registerClient", () => {
    const body: api.ClientRegistration = undefined
    return expect(instance.registerClient(body, {})).resolves.toBe(null)
  })
  test("updateClientRegistration", () => {
    const body: api.ClientRegistration = undefined
    return expect(instance.updateClientRegistration(body, {})).resolves.toBe(null)
  })
})

describe("OAuthApi", () => {
  let instance: api.OAuthApi
  beforeEach(function() {
    instance = new api.OAuthApi(config)
  });

  test("authorizeOAuth", () => {
    const clientId: string = "clientId_example"
    const responseType: string = "responseType_example"
    const scope: Array<string> = undefined
    const redirectUri: string = "redirectUri_example"
    const state: string = "state_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const codeChallenge: string = "codeChallenge_example"
    const codeChallengeMethod: string = "codeChallengeMethod_example"
    const prompt: string = "prompt_example"
    const nonce: string = "nonce_example"
    return expect(instance.authorizeOAuth(clientId, responseType, scope, redirectUri, state, xIdempotencyKey, xFapiAuthDate, xFapiCustomerLastLoggedTime, codeChallenge, codeChallengeMethod, prompt, nonce, {})).resolves.toBe(null)
  })
  test("getOAuthToken", () => {
    const grantType: string = "grantType_example"
    const code: string = "code_example"
    const redirectUri: string = "redirectUri_example"
    const clientId: string = "clientId_example"
    const refreshToken: string = "refreshToken_example"
    const clientAssertionType: string = "clientAssertionType_example"
    const clientAssertion: string = "clientAssertion_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.getOAuthToken(grantType, code, redirectUri, clientId, refreshToken, clientAssertionType, clientAssertion, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("getUserInfo", () => {
    const authorization: string = "authorization_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.getUserInfo(authorization, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("introspectToken", () => {
    const token: string = "token_example"
    const authorization: string = "authorization_example"
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.introspectToken(token, authorization, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId, {})).resolves.toBe(null)
  })
  test("oAuthPAR", () => {
    const body: api.OauthAuthBody = undefined
    const participantId: string = "participantId_example"
    const xV: number = 56
    const xFapiAuthDate: Date = 2013-10-20T19:20:30+01:00
    const xFapiCustomerIpAddress: string = "xFapiCustomerIpAddress_example"
    const xClientHeaders: string = "xClientHeaders_example"
    const xClientUserAgent: string = "xClientUserAgent_example"
    const xIdempotencyKey: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    const xFapiCustomerLastLoggedTime: Date = 2013-10-20T19:20:30+01:00
    const xFapiInteractionId: string = "38400000-8cf0-11bd-b23e-10b96e4ef00d"
    return expect(instance.oAuthPAR(body, participantId, xV, xFapiAuthDate, xFapiCustomerIpAddress, xClientHeaders, xClientUserAgent, xIdempotencyKey, xFapiCustomerLastLoggedTime, xFapiInteractionId, {})).resolves.toBe(null)
  })
})

