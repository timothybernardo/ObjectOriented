/* ============================================================================
 * TASK 2: Implement PayPal Payment Strategy
 * ============================================================================ */

class PayPalPayment implements PaymentStrategy {
  private String email;
  private String password;

  public PayPalPayment(String email, String password) {
    // TODO: Initialize fields

  }

  @Override
  public boolean validate() {
    // TODO: Validate PayPal credentials
    // - Email should contain '@'
    // - Password length should be >= 8
    // Print validation result

    return false; // placeholder
  }

  @Override
  public boolean processPayment(double amount) {
    // TODO: Process PayPal payment
    // Print: "Redirecting to PayPal..."
    // Print: "Processing $[amount] via PayPal account [email]"
    // Return true

    return false; // placeholder
  }
}