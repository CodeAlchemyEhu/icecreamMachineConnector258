# 🍨 Icecream Machine Middleware

## 🎯 Goal
Design and implement a **middleware** between the `OrderDesk` (front-end) and the `IcecreamMachine` interface.  
The middleware must translate dessert orders into preparation commands for the ice cream machine.

---

## 🧠 Task Description

Implement a middleware layer (the `IcecreamMachineController`) that connects the `OrderDesk` and the `IcecreamMachine`.

1. The controller must **interpret each dessert type** and send the correct preparation command to the ice cream machine.

2. The configuration for each dessert type (e.g. ice cream, milkshake, smoothie) should not be hard-coded directly in the controller.

3. Use **creational design patterns** to build a flexible and extensible design.

4. Each dessert type should define:

   - **Frozen ice cream mass (g)**
   - **Milk volume (ml)**
   - **Juice volume (ml)**
   - **Water volume (ml)**

5. Send the command to the machine in the format:
   ```
   "<frozenMass>g <milk>ml <juice>ml <water>ml"
   ```
   
7. Each region-specific factory must return versions of desserts with **region-dependent ingredient values**  
   (e.g. USA = larger servings, Japan = smaller portions, etc.).

---

## 🌍 Regional Recipe Table

| Region          | Ice Cream (F/M/J/W)      | Milkshake (F/M/J/W)       | Smoothie (F/M/J/W)        | Notes               |
|-----------------|--------------------------|---------------------------|---------------------------|---------------------|
| **Brazil** 🇧🇷 | 220g / 20ml / 0ml / 15ml | 130g / 230ml / 0ml / 25ml | 35g / 40ml / 240ml / 60ml | Sweet & fruity      |
| **India** 🇮🇳  | 200g / 25ml / 0ml / 20ml | 120g / 210ml / 0ml / 20ml | 30g / 40ml / 220ml / 55ml | Creamy & refreshing |

---
## 📝 New task for structural design patterns

### ✔ 1. Add Toppings Support
Extend the dessert order logic so a user can request toppings, for example:
```
icecream marshmallow syrup
```
The list of toppings:
- **Chocolate**
- **Marshmallowm**
- **Syrup**

Toppings can be combined

### ✔ 2. Maintain Backward Compatibility

Not all machines support toppings.

Old connector: must still work exactly as before and support topping functionality

New connector: must fully support toppings

Your implementation must ensure the system can work with either connector without breaking existing functionality.



### ✔ 3. ☕ NewIcecreamMachineConnector – Overview

`NewIcecreamMachineConnector` is a connector class that simulates communication with a dessert machine device.
It implements the `IcecreamMachineV77` interface and provides a controlled workflow for interacting with the machine.

Typical lifecycle:
```
1. getToken()
2. openSession(token)
3. makeDessert(token, session, "150g 200ml 0ml 20ml chocolate")
4. closeSession(token, session)
```
The connector supports the following operations:

**Requesting a token** – retrieves a unique authentication token for connector.

**Opening a session** – establishes a session using the provided token.

**Preparing dessert** – performs a simulated dessert preparation within an active session.

**Closing the session** – gracefully ends the active session.

Additionally, the connector implements strict validation rules to ensure proper usage.

Only one session can be open at any time

This behavior mimics real-world external device integrations where authentication, session control, and state validation are required.


---

## 📝 New task for behavioral design patterns p.1


### 🧠 Task – Order Price Calculation
Extend the dessert ordering system to **calculate the final order price** dynamically, depending on:

- dessert type
- region
- applied discount rules

Use **stratagy** pattern


#### ✔ Description

Each dessert order must be able to calculate its **base price** and then apply **one discount strategy**.


#### ✔ Regional Dessert Price Table

#### ☕ Base Dessert Prices (USD)

| Region         | Ice Cream | Milkshake | Smoothie |
|----------------|----------|-----------|-------|
| **USA** 🇺🇸   | $2.00    | $3.50     | $4.00 |
| **Japan** 🇯🇵 | $1.80    | $3.20     | $3.80 |


#### 🍯 Topping Prices (USD)

| Topping  | Price |
|---------|-------|
| Chocolate | $0.70 |
| Marshmallow   | $0.40 |
| Syrup  | $0.80 |

- Toppings can be combined
- Each topping adds its price to the base dessert price

#### ✔ Discount Strategies

Only **one discount** may be applied per order.

| Discount Type       | Rule |
|---------------------|------|
| **None**            | No discount |
| **Student** 🎓      | 20% off total price |
| **Loyalty Card** 💳 | 10% off total price |



#### ✔ Example Usage

```
student icecream marshmallow syrup

none milkshake
```

### 🧠 Task – Order Processing Pipeline

#### 🎯 Goal
Refactor the order processing logic into a **step-by-step processing pipeline** where each step is responsible for **exactly one concern**.

Use **Chain of Responsibility** pattern

#### ✔ Description

Processing a dessert order involves multiple sequential actions, such as (examples):

- parsing the input string
- identifying dessert type
- applying toppings
- applying discount rules

### 🧠 Task – Icecream Machine Connector States

### 🎯 Goal
Enhance the `IcecreamMachineConnector` to behave differently depending on its **internal state**, simulating a real-world unstable external device.

The connector must automatically switch between states based on **successes and failures** during operation.

Use **state** pattern


#### ✔ Description

The Icecream Machine Connector must operate in **three distinct states**:

1. **OPEN**
2. **CLOSED**
3. **SEMI-CLOSED**

Each state defines how the connector reacts to incoming dessert preparation requests.

#### ✔ State Definitions & Rules

##### 🟢 OPEN State
- Normal operating mode
- All requests are executed normally
- If **2 exceptions occur processing**:
   - the connector switches to **CLOSED** state

##### 🔴 CLOSED State
- Protective mode
- The connector **ignores the next 5 incoming calls**
- Ignored calls:
   - must not reach the real Icecream Machine
- After 5 ignored calls:
   - the connector switches to **SEMI-CLOSED** state

##### 🟡 SEMI-CLOSED State
- Testing mode
- The connector allows **exactly one request** to pass through
- If the request:
   - **succeeds** → switch to **OPEN**
   - **fails** → switch back to **CLOSED**