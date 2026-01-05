import java.util.*;

/* ============================================================================
 * SCENARIO: You're building an e-commerce checkout system that needs to
 * support different payment methods. Each payment method has different
 * validation rules and processing steps.
 * ============================================================================ */

// STRATEGY INTERFACE - Define the common interface for all payment strategies
interface PaymentStrategy {
  /**
   * Process a payment with the given amount
   *
   * @param amount The amount to charge
   * @return true if payment successful, false otherwise
   */
  boolean processPayment(double amount);

  /**
   * Validate payment details before processing
   *
   * @return true if details are valid
   */
  boolean validate();
}
