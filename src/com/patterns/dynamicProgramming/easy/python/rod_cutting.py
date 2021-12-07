# --------------------------------- TOP DOWN DP ---------------------------------

def rod_cutting_top_down_dp(price, length, max_profits_table, cuts_table):

    if length == 0:

        return 0, cuts_table

    if max_profits_table[length] == -1:

        for i in range(1, length + 1):

            price_if_cut_at_length_i = price[i] + rod_cutting_top_down_dp(price, length - i,
                                                                          max_profits_table, cuts_table)[0]

            if price_if_cut_at_length_i > max_profits_table[length]:

                max_profits_table[length] = price_if_cut_at_length_i
                cuts_table[length] = i

    return max_profits_table[length], cuts_table


def top_down_driver_function(price, length):

    max_profits_table = [-1 for _ in range(length + 1)]
    cuts_table = [0 for _ in range(length + 1)]

    max_profit, cuts = rod_cutting_top_down_dp(price, length, max_profits_table, cuts_table)

    n = length
    answer_table = []

    while n > 0:

        answer_table.append(cuts_table[n])
        n -= cuts_table[n]

    return answer_table, max_profit


# --------------------------------- BOTTOM UP DP ---------------------------------


def rod_cutting_bottom_up_dp(price, length):

    max_profit_table = [0 for _ in range(length + 1)]
    cuts_table = [0 for _ in range(length + 1)]

    for i in range(1, length + 1):

        for j in range(1, i + 1):

            price_if_cut_at_length_j_of_rod_with_length_i = price[j] + max_profit_table[i - j]

            if price_if_cut_at_length_j_of_rod_with_length_i > max_profit_table[i]:

                max_profit_table[i] = price_if_cut_at_length_j_of_rod_with_length_i
                cuts_table[i] = j

    n = length
    answer_table = []

    while n > 0:

        answer_table.append(cuts_table[n])
        n -= cuts_table[n]

    return answer_table, max_profit_table[length]


# --------------------------------- TEST CODE ---------------------------------

price_arr = [0, 2, 5, 9, 10, 12, 13, 15, 16]
rod_length = 8

print(top_down_driver_function(price_arr, rod_length))
print(rod_cutting_bottom_up_dp(price_arr, rod_length))
