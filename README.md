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


