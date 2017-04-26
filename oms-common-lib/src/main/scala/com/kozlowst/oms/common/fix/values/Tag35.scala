package com.kozlowst.oms.common.fix.values

/**
  * Created by tomek on 4/23/17.
  */
object Tag35 extends Enumeration {

  /*
  TODO: do it generic, TransFIX engine
  * http://www.fixtradingcommunity.org/FIXimate/FIXimate3.0/en/FIX.4.4/tag35.html
0	= Heartbeat Added  FIX.2.7		[Heartbeat]
1	= Test Request Added  FIX.2.7		[TestRequest]
2	= Resend Request Added  FIX.2.7		[ResendRequest]
3	= Reject Added  FIX.2.7		[Reject]
4	= Sequence Reset Added  FIX.2.7		[SequenceReset]
5	= Logout Added  FIX.2.7		[Logout]
6	= Indication of Interest Added  FIX.2.7		[IOI]
7	= Advertisement Added  FIX.2.7		[Advertisement]
8	= Execution Report Added  FIX.2.7		[ExecutionReport]
9	= Order Cancel Reject Added  FIX.2.7		[OrderCancelReject]
A	= Logon Added  FIX.2.7		[Logon]
B	= News Added  FIX.2.7		[News]
C	= Email Added  FIX.2.7		[Email]
D	= Order – Single Added  FIX.2.7		[NewOrderSingle]
E	= Order – List Added  FIX.2.7		[NewOrderList]
F	= Order Cancel Request Added  FIX.2.7		[OrderCancelRequest]
G	= Order Cancel/Replace Request Added  FIX.2.7		[OrderCancelReplaceRequest]
H	= Order Status Request Added  FIX.2.7		[OrderStatusRequest]
J	= Allocation Instruction Added  FIX.2.7		[AllocationInstruction]
K	= List Cancel Request Added  FIX.2.7		[ListCancelRequest]
L	= List Execute Added  FIX.2.7		[ListExecute]
M	= List Status Request Added  FIX.2.7		[ListStatusRequest]
N	= List Status Added  FIX.2.7		[ListStatus]
P	= Allocation Instruction Ack Added  FIX.2.7		[AllocationInstructionAck]
Q	= Don’t Know Trade (DK) Added  FIX.4.0		[DontKnowTrade]
R	= Quote Request Added  FIX.4.0		[QuoteRequest]
S	= Quote Added  FIX.4.0		[Quote]
T	= Settlement Instructions Added  FIX.4.1		[SettlementInstructions]
V	= Market Data Request Added  FIX.4.2		[MarketDataRequest]
W	= Market Data-Snapshot/Full Refresh Added  FIX.4.2		[MarketDataSnapshotFullRefresh]
X	= Market Data-Incremental Refresh Added  FIX.4.2		[MarketDataIncrementalRefresh]
Y	= Market Data Request Reject Added  FIX.4.2		[MarketDataRequestReject]
Z	= Quote Cancel Added  FIX.4.2		[QuoteCancel]
a	= Quote Status Request Added  FIX.4.2		[QuoteStatusRequest]
b	= Mass Quote Acknowledgement Added  FIX.4.2		[MassQuoteAcknowledgement]
c	= Security Definition Request Added  FIX.4.2		[SecurityDefinitionRequest]
d	= Security Definition Added  FIX.4.2		[SecurityDefinition]
e	= Security Status Request Added  FIX.4.2		[SecurityStatusRequest]
f	= Security Status Added  FIX.4.2		[SecurityStatus]
g	= Trading Session Status Request Added  FIX.4.2		[TradingSessionStatusRequest]
h	= Trading Session Status Added  FIX.4.2		[TradingSessionStatus]
i	= Mass Quote Added  FIX.4.2		[MassQuote]
j	= Business Message Reject Added  FIX.4.2		[BusinessMessageReject]
k	= Bid Request Added  FIX.4.2		[BidRequest]
l	= Bid Response (lowercase L) Added  FIX.4.2		[BidResponse]
m	= List Strike Price Added  FIX.4.2		[ListStrikePrice]
n	= XML message (e.g. non-FIX MsgType) Added  FIX.4.3		[XMLNonFIX]
o	= Registration Instructions Added  FIX.4.3		[RegistrationInstructions]
p	= Registration Instructions Response Added  FIX.4.3		[RegistrationInstructionsResponse]
q	= Order Mass Cancel Request Added  FIX.4.3		[OrderMassCancelRequest]
r	= Order Mass Cancel Report Added  FIX.4.3		[OrderMassCancelReport]
s	= New Order - Cross Added  FIX.4.3		[NewOrderCross]
t	= Cross Order Cancel/Replace Request (a.k.a. Cross Order Modification Request) Added  FIX.4.3		[CrossOrderCancelReplaceRequest]
u	= Cross Order Cancel Request Added  FIX.4.3		[CrossOrderCancelRequest]
v	= Security Type Request Added  FIX.4.3		[SecurityTypeRequest]
w	= Security Types Added  FIX.4.3		[SecurityTypes]
x	= Security List Request Added  FIX.4.3		[SecurityListRequest]
y	= Security List Added  FIX.4.3		[SecurityList]
z	= Derivative Security List Request Added  FIX.4.3		[DerivativeSecurityListRequest]
AA	= Derivative Security List Added  FIX.4.3		[DerivativeSecurityList]
AB	= New Order - Multileg Added  FIX.4.3		[NewOrderMultileg]
AC	= Multileg Order Cancel/Replace (a.k.a. Multileg Order Modification Request) Added  FIX.4.3		[MultilegOrderCancelReplace]
AD	= Trade Capture Report Request Added  FIX.4.3		[TradeCaptureReportRequest]
AE	= Trade Capture Report Added  FIX.4.3		[TradeCaptureReport]
AF	= Order Mass Status Request Added  FIX.4.3		[OrderMassStatusRequest]
AG	= Quote Request Reject Added  FIX.4.3		[QuoteRequestReject]
AH	= RFQ Request Added  FIX.4.3		[RFQRequest]
AI	= Quote Status Report Added  FIX.4.3		[QuoteStatusReport]
AJ	= Quote Response Added  FIX.4.4		[QuoteResponse]
AK	= Confirmation Added  FIX.4.4		[Confirmation]
AL	= Position Maintenance Request Added  FIX.4.4		[PositionMaintenanceRequest]
AM	= Position Maintenance Report Added  FIX.4.4		[PositionMaintenanceReport]
AN	= Request For Positions Added  FIX.4.4		[RequestForPositions]
AO	= Request For Positions Ack Added  FIX.4.4		[RequestForPositionsAck]
AP	= Position Report Added  FIX.4.4		[PositionReport]
AQ	= Trade Capture Report Request Ack Added  FIX.4.4		[TradeCaptureReportRequestAck]
AR	= Trade Capture Report Ack Added  FIX.4.4		[TradeCaptureReportAck]
AS	= Allocation Report (aka Allocation Claim) Added  FIX.4.4		[AllocationReport]
AT	= Allocation Report Ack (aka Allocation Claim Ack) Added  FIX.4.4		[AllocationReportAck]
AU	= Confirmation Ack (aka Affirmation) Added  FIX.4.4		[ConfirmationAck]
AV	= Settlement Instruction Request Added  FIX.4.4		[SettlementInstructionRequest]
AW	= Assignment Report Added  FIX.4.4		[AssignmentReport]
AX	= Collateral Request Added  FIX.4.4		[CollateralRequest]
AY	= Collateral Assignment Added  FIX.4.4		[CollateralAssignment]
AZ	= Collateral Response Added  FIX.4.4		[CollateralResponse]
BA	= Collateral Report Added  FIX.4.4		[CollateralReport]
BB	= Collateral Inquiry Added  FIX.4.4		[CollateralInquiry]
BC	= Network (Counterparty System) Status Request Added  FIX.4.4		[NetworkCounterpartySystemStatusRequest]
BD	= Network (Counterparty System) Status Response Added  FIX.4.4		[NetworkCounterpartySystemStatusResponse]
BE	= User Request Added  FIX.4.4		[UserRequest]
BF	= User Response Added  FIX.4.4		[UserResponse]
BG	= Collateral Inquiry Ack Added  FIX.4.4		[CollateralInquiryAck]
BH	= Confirmation Request Added  FIX.4.4		[ConfirmationRequest]
  * */

  type Tag35 = Value

  /**
    * Heartbeat
    * Allows the client and the OCG to exercise the communication line during periods of
    * inactivity and verify that the interfaces at each end are available.
    * */
  val Heartbeat = Value("0")

  /**
    * Test Request
    * Allows the client or the OCG to request a response from the other party if inactivity is detected.
    * */
  val TestRequest = Value("1")

  /**
    * Resend Request
    * Allows for the recovery of messages lost during a malfunction of the communications layers.
    * */
  val ResendRequest = Value("2")

  /**
    * Reject
    * Used to reject a message that does not comply with session level validations.
    * */
  val Reject = Value("3")

  /**
    * Sequence Reset
    * Allows the client or the OCG to increase the expected incoming sequence number of the other party.
    * */
  val SequenceReset = Value("4")

  /**
    * Logon
    * Allows the client and the OCG to establish a FIX session.
    * */
  val Logon = Value("A")

  /**
    * Logout
    * Allows the client and the OCG to terminate a FIX session.
    * */
  val Logout = Value("5")

  /**
    * Business Message Reject
    * Indicates that an application message could not be processed
    * */
  val BusinessMessageReject = Value("j")

  /**
    * Execution report
    *
    * Indicates one of the following:
    * Order Accepted
    * Order Rejected
    * Order Expired
    * Order Cancelled
    * Order Replaced
    * Trade
    * Trade Cancel
    * */
  val ExecutionReport = Value("8")

  /**
    * Indicates that either a Cancel or Cancel/Replace request has been rejected
    * */
  val OrderCancelReject = Value("9")

  /**
    * Allows the client to submit a new order.
    * */
  val NewOrderSingle = Value("D")

  /**
    * Allows the client to cancel a live order in the execution venue.
    * */
  val OrderCancelRequest = Value("F")

  /**
    * Allows the client to amend specific attributes a live order.
    * */
  val OrderCancelReplaceRequest = Value("G")

  /**
    * Allows the client to mass cancel:
    * All live orders
    * All live orders for a particular instrument.
    * All live orders for a particular market segment.
    * */
  val MassCancelRequest = Value("q")

  /**
    * Indicates one of the following:
    * Mass cancel request accepted.
    * Mass cancel request rejected.
    * */
  val OrderMassCancelReport = Value("r")

  /**
    * Allows the client to submit a quote for a single instrument.
    * */
  val Quote = Value("S")

  /**
    * Allows the client to cancel a quote for a particular instrument.
    * */
  val QuoteCancel = Value("Z")

  /**
    * Indicates one of the following:
    * Quote rejected
    * Request to cancel a quote rejected
    * */
  val QuoteStatusReport = Value("AI")

  /**
    * Indicates one of the following:
    * Trade Submit
    * Trade Cance
    * */
  val TradeCaptureReport = Value("AE")

  /**
    *  Indicates one of the following:
    * Reject Trade
    * Reject Trade Cancel
    * */
  val TradeCaptureReportAck = Value("AR")

  /**
    *
    * Allows the client to cancel a live order in the execution venue on behalf of another user
    * */
  val OBOCancelRequest = Value("F")

  /**
    *
    * Allows the client to carry out mass cancellations on behalf of another user at the following order levels:
    * All live orders.
    * All live orders for a particular instrument.
    * All live orders for a particular market segment
    * */
  val OBOMassCancelRequest = Value("q")


  /**
    *
    * Allows the client to request for throttle entitlement details
    * */
  val UserRequest = Value("BE")

  /**
    *
    * Response to the User Request
    * */
  val UserResponse = Value("BF")

  /**
    *
    * Request entitlement information for Exchange participant
    * */
  val PartyEntitlementsRequest = Value("CU")

  /**
    *
    * Response to Party Entitlements Request
    * */
  val PartyEntitlementsReport = Value("CV")

}
