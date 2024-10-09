# import math

# def calculate_rma(close_values, period, previous_rma):
#     rma = previous_rma
#     for i in range(len(close_values)):
#         rma = ((rma * (period - 1)) + close_values[i]) / period
#     return rma

# def calculate_rsi(close_values, period, previous_rma):
#     gains = []
#     losses = []
#     avg_gain = previous_rma
#     avg_loss = previous_rma

#     for i in range(1, len(close_values)):
#         change = close_values[i] - close_values[i - 1]
#         if change > 0:
#             gain = change
#             loss = 0
#         else:
#             gain = 0
#             loss = -change  # Loss is positive in this context

#         gains.append(gain)
#         losses.append(loss)

#         avg_gain = ((avg_gain * (period - 1)) + gain) / period
#         avg_loss = ((avg_loss * (period - 1)) + loss) / period

#     # Calculate RS and RSI
#     rs = avg_gain / avg_loss if avg_loss != 0 else 100
#     rsi = 100 - (100 / (1 + rs))

#     return rsi

# # Test with close values and previous RMA
# close_values = [1588.54, 1598.93, 1570.35, 1560.26, 1555.09,1558.111]
# previous_rma = 1572.517
# rsi_period = 5

# # Calculate RMA and RSI
# rma_value = calculate_rma(close_values, rsi_period, previous_rma)
# rsi_value = calculate_rsi(close_values, rsi_period, previous_rma)

# print(f"Calculated RMA: {rma_value}")
# print(f"Calculated RSI: {rsi_value}")

# Given close prices
close_prices = [
    1628.699951,
    1639.349976,
    1610.050049,
    1599.699951,
    1594.400024
]

# Calculate the gains and losses
gains = []
losses = []

for i in range(1, len(close_prices)):
    change = close_prices[i] - close_prices[i - 1]
    if change > 0:
        gains.append(change)
        losses.append(0)
    else:
        losses.append(-change)  # Loss is positive in this context
        gains.append(0)

# Calculate the average gain and average loss
average_gain = sum(gains) / len(gains)
average_loss = sum(losses) / len(losses)

# Calculate the "up" and "down" values
up = average_gain  # Up is the average gain
down = average_loss  # Down is the average loss

# Calculate RSI using the formula
rsi = down == 0 and 100 or up == 0 and 0 or 100 - (100 / (1 + up / down))

up, down, rsi
