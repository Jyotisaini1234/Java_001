import numpy as np

def rma_tv(source: np.ndarray, length: int) -> np.ndarray:
    """
    Calculate the RMA (Relative Moving Average).
    
    Parameters
    ----------
    source : np.ndarray
        Values to process
    length : int
        Number of bars

    Returns
    -------
    np.ndarray
        RMA values
    """
    if length <= 0 or length > source.size:
        raise ValueError("Length must be a positive integer and less than the size of the source array.")

    rma = np.full_like(source, np.nan)
    
    # Start calculating RMA only if we have enough data
    if source.size >= length:
        rma[length - 1] = np.nanmean(source[:length])  # Calculate the first RMA value

        alpha = 1 / length
        for i in range(length, source.size):
            rma[i] = alpha * source[i] + (1 - alpha) * rma[i - 1]

    return rma

def calculate_rsi(closing_prices: np.ndarray, length: int) -> float:
    # Validate input
    if length <= 0 or length > closing_prices.size:
        raise ValueError("Length must be a positive integer and less than the size of the closing prices array.")
    
    # Calculate price changes
    price_changes = np.diff(closing_prices)

    # Initialize gains and losses arrays
    gains = np.maximum(price_changes, 0)
    losses = np.maximum(-price_changes, 0)

    # Add NaN for the first value
    gains = np.insert(gains, 0, np.nan)
    losses = np.insert(losses, 0, np.nan)

    # Calculate RMA for gains and losses
    rma_gains = rma_tv(gains, length)
    rma_losses = rma_tv(losses, length)

    # Calculate RS
    last_rma_gain = rma_gains[-1]
    last_rma_loss = rma_losses[-1]
    
    if last_rma_loss == 0:
        return 100  # RSI of 100 if no losses
    elif last_rma_gain == 0:
        return 0  # RSI of 0 if no gains
    else:
        rs = last_rma_gain / last_rma_loss
        rsi = 100 - (100 / (1 + rs))
        return rsi

# Given closing prices
closing_prices = np.array([1905.65,2014.45, 1930.45, 1932.75, 1903.6])

# Calculate RSI
rsi_value = calculate_rsi(closing_prices, length=5)

print("RSI:", rsi_value)
