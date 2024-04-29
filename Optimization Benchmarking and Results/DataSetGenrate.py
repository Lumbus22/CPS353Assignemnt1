import random

# Function to generate random numbers for a given size
def generate_random_numbers(size):
    return [random.randint(1, 10**size) for _ in range(10)]

# Sizes to generate random numbers for
sizes = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]

# Generate random numbers for each size
random_numbers_by_size = {}
for size in sizes:
    random_numbers_by_size[size] = generate_random_numbers(size)

# Print random numbers for each size
for size, numbers in random_numbers_by_size.items():
    print(numbers)
