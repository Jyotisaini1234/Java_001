

import numpy as np

def rma_tv(source: np.ndarray, length: int) -> np.ndarray:
    if length <= 0 or length > source.size:
        raise ValueError("Length must be a positive integer and less than the size of the source array.")

    rma = np.full_like(source, np.nan)
    
    if source.size >= length:
        rma[length - 1] = np.nanmean(source[:length])

        alpha = 1 / length
        for i in range(length, source.size):
            rma[i] = alpha * source[i] + (1 - alpha) * rma[i - 1]

    return rma

def calculate_rsi(closing_prices: np.ndarray, length: int) -> float:
    if length <= 0 or length > closing_prices.size:
        raise ValueError("Length must be a positive integer and less than the size of the closing prices array.")
    
    price_changes = np.diff(closing_prices)
    gains = np.maximum(price_changes, 0)
    losses = np.maximum(-price_changes, 0)

    gains = np.insert(gains, 0, np.nan)
    losses = np.insert(losses, 0, np.nan)

    rma_gains = rma_tv(gains, length)
    rma_losses = rma_tv(losses, length)

    last_rma_gain = rma_gains[-1]
    last_rma_loss = rma_losses[-1]
    
    print("Gains:", gains)
    print("Losses:", losses)
    print("RMA Gains:", rma_gains)
    print("RMA Losses:", rma_losses)
    print("Last RMA Gain:", last_rma_gain)
    print("Last RMA Loss:", last_rma_loss)

    if last_rma_loss == 0:
        return 100
    elif last_rma_gain == 0:
        return 0
    else:
        rs = last_rma_gain / last_rma_loss
        rsi = 100 - (100 / (1 + rs))
        return rsi

# Given closing prices
closing_prices = np.array([1905.65, 2014.45, 1930.45, 1932.75, 1903.6, 1891.65, 1893.4, 1935.3, 1949.5,1949.65,1902.35,1892.9,1948.65,1953.6])

# Calculate RSI
rsi_value = calculate_rsi(closing_prices, length=7)

print("RSI:", rsi_value)
