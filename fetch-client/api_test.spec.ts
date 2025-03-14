/**
 * OFxPERA API
 * Philippines Open Finance API Implementation for PERA
 *
 * OpenAPI spec version: 0.0.5
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
    return expect(instance.getParticipant(participantId, {})).resolves.toBe(null)
  })
  test("listParticipants", () => {
    return expect(instance.listParticipants({})).resolves.toBe(null)
  })
  test("listProductByParticipant", () => {
    const participantId: string = "participantId_example"
    return expect(instance.listProductByParticipant(participantId, {})).resolves.toBe(null)
  })
  test("registerParticipant", () => {
    const body: api.ParticipantConfig = undefined
    return expect(instance.registerParticipant(body, {})).resolves.toBe(null)
  })
  test("registerProduct", () => {
    return expect(instance.registerProduct({})).resolves.toBe(null)
  })
  test("updateParticipant", () => {
    const body: api.ParticipantConfig = undefined
    return expect(instance.updateParticipant(body, {})).resolves.toBe(null)
  })
  test("updateProduct", () => {
    const productId: string = "productId_example"
    return expect(instance.updateProduct(productId, {})).resolves.toBe(null)
  })
})

describe("CommonApi", () => {
  let instance: api.CommonApi
  beforeEach(function() {
    instance = new api.CommonApi(config)
  });

  test("forwardCustomerEndorsement", () => {
    const endorsement: string = "endorsement_example"
    return expect(instance.forwardCustomerEndorsement(endorsement, {})).resolves.toBe(null)
  })
  test("getCustomerDetail", () => {
    const customerId: string = "customerId_example"
    return expect(instance.getCustomerDetail(customerId, {})).resolves.toBe(null)
  })
})

describe("ConsentApi", () => {
  let instance: api.ConsentApi
  beforeEach(function() {
    instance = new api.ConsentApi(config)
  });

  test("bulkUpdateCustomerConsents", () => {
    const body: api.ArrangementsBulkupdateBody = undefined
    const customerId: string = "customerId_example"
    return expect(instance.bulkUpdateCustomerConsents(body, customerId, {})).resolves.toBe(null)
  })
  test("createBulkConsent", () => {
    const body: api.BulkConsentRequest = undefined
    return expect(instance.createBulkConsent(body, {})).resolves.toBe(null)
  })
  test("createConsentArrangement", () => {
    const body: api.ConsentArrangementRequest = undefined
    return expect(instance.createConsentArrangement(body, {})).resolves.toBe(null)
  })
  test("extendConsentDuration", () => {
    const body: api.ConsentExtensionRequest = undefined
    const arrangementId: string = "arrangementId_example"
    return expect(instance.extendConsentDuration(body, arrangementId, {})).resolves.toBe(null)
  })
  test("getConsentArrangement", () => {
    const arrangementId: string = "arrangementId_example"
    return expect(instance.getConsentArrangement(arrangementId, {})).resolves.toBe(null)
  })
  test("getConsentHistory", () => {
    const arrangementId: string = "arrangementId_example"
    return expect(instance.getConsentHistory(arrangementId, {})).resolves.toBe(null)
  })
  test("getCustomerConsentDashboard", () => {
    const customerId: string = "customerId_example"
    return expect(instance.getCustomerConsentDashboard(customerId, {})).resolves.toBe(null)
  })
  test("getCustomerConsents", () => {
    const customerId: string = "customerId_example"
    const status: string = "status_example"
    const dataHolderId: string = "dataHolderId_example"
    const purpose: string = "purpose_example"
    return expect(instance.getCustomerConsents(customerId, status, dataHolderId, purpose, {})).resolves.toBe(null)
  })
  test("listConsentArrangements", () => {
    const status: string = "status_example"
    const fromDate: Date = 2013-10-20T19:20:30+01:00
    const toDate: Date = 2013-10-20T19:20:30+01:00
    return expect(instance.listConsentArrangements(status, fromDate, toDate, {})).resolves.toBe(null)
  })
  test("listConsentTemplates", () => {
    const category: string = "category_example"
    const purpose: string = "purpose_example"
    return expect(instance.listConsentTemplates(category, purpose, {})).resolves.toBe(null)
  })
  test("revokeConsentArrangement", () => {
    const arrangementId: string = "arrangementId_example"
    return expect(instance.revokeConsentArrangement(arrangementId, {})).resolves.toBe(null)
  })
  test("updateConsentStatus", () => {
    const body: api.ConsentStatusUpdate = undefined
    const arrangementId: string = "arrangementId_example"
    return expect(instance.updateConsentStatus(body, arrangementId, {})).resolves.toBe(null)
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
    const codeChallenge: string = "codeChallenge_example"
    const codeChallengeMethod: string = "codeChallengeMethod_example"
    const prompt: string = "prompt_example"
    const nonce: string = "nonce_example"
    return expect(instance.authorizeOAuth(clientId, responseType, scope, redirectUri, state, codeChallenge, codeChallengeMethod, prompt, nonce, {})).resolves.toBe(null)
  })
  test("getOAuthToken", () => {
    const grantType: string = "grantType_example"
    const code: string = "code_example"
    const redirectUri: string = "redirectUri_example"
    const clientId: string = "clientId_example"
    const refreshToken: string = "refreshToken_example"
    return expect(instance.getOAuthToken(grantType, code, redirectUri, clientId, refreshToken, {})).resolves.toBe(null)
  })
  test("getUserInfo", () => {
    return expect(instance.getUserInfo({})).resolves.toBe(null)
  })
  test("introspectToken", () => {
    const token: string = "token_example"
    return expect(instance.introspectToken(token, {})).resolves.toBe(null)
  })
  test("oAuthPAR", () => {
    const body: api.OauthAuthBody = undefined
    return expect(instance.oAuthPAR(body, {})).resolves.toBe(null)
  })
})

describe("PERAApi", () => {
  let instance: api.PERAApi
  beforeEach(function() {
    instance = new api.PERAApi(config)
  });

  test("getArrangementStatus", () => {
    const arrangementId: string = "arrangementId_example"
    return expect(instance.getArrangementStatus(arrangementId, {})).resolves.toBe(null)
  })
  test("peraArrangementRegistration", () => {
    return expect(instance.peraArrangementRegistration({})).resolves.toBe(null)
  })
})

