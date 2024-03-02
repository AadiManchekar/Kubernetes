Kubernetes probes are mechanisms that the kubelet (the Kubernetes agent running on each node) uses to monitor container health and ensure pods are operating as intended.

Startup Probe:
Determines if a container application has fully initialized and is ready to start handling requests.
Prevents liveness and readiness probes from running until the startup probe succeeds, allowing slow-starting applications time to initialize.

Liveness Probe:
Determines if a container application is alive and functioning.
If the probe fails, the kubelet restarts the container, attempting to recover from a faulty state.

Readiness Probe:
Determines if a container is ready to receive traffic.
If the probe fails, Kubernetes temporarily removes the pod from the service load balancer, directing traffic away until the pod becomes ready.



- Liveness Probe: initialDelaySeconds: 60 means the probe waits for 60 seconds after becoming active (which happens immediately after the successful startup probe) before it sends the first HTTP GET request to /healthz.

- Readiness Probe: initialDelaySeconds: 5 means the probe waits for 5 seconds after becoming active before it sends the first HTTP GET request to /.


Reasoning:
- The liveness probe has a longer initial delay (60 seconds) compared to the readiness probe (5 seconds) because it's usually crucial to allow the application more time to reach a healthy state before potential restarts for perceived unhealthiness. A longer delay helps avoid unnecessary restarts during the initial application startup phase.

- The readiness probe might have a shorter initial delay (5 seconds) because it checks for basic readiness (e.g., serving requests) and might not require as much time as the liveness probe to ensure overall application health.

Overall:
- While the liveness and readiness probes become active instantly after the successful startup probe, the initialDelaySeconds setting determines when they begin their first actual checks, providing necessary breathing room for the application to complete its startup process and reach a healthy state.


## Summary: Pod Startup and Probe Execution

**Pod Starts:** Kubernetes starts the pod, initiating container creation and application startup.

**Wait 30 seconds:** The kubelet waits for the configured `initialDelaySeconds` (30 seconds) before initiating any probe checks.

**Start Startup Probe:** After the initial delay, the startup probe begins checking the application's health (e.g., calling `/healthz`). This probe continues every 5 seconds (`periodSeconds`) until successful.

**Immediately after successful startup probe:**

* **Liveness Probe and Readiness Probe become active.**
* **Liveness Probe:** Despite activation, it waits additionally for 60 seconds (`initialDelaySeconds`) before sending its first health check request (e.g., `/healthz`). This delay helps avoid unnecessary restarts during application startup.
* **Readiness Probe:** Despite activation, it waits additionally for 5 seconds (`initialDelaySeconds`) before sending its first readiness check request (e.g., `/`). This allows some time for the application to become ready before being exposed to traffic.

**Liveness Probe:** Once the initial delay is complete, the probe starts checking the application's health every 10 seconds (`periodSeconds`). If the probe fails three consecutive times (`failureThreshold`), the pod is considered unhealthy and restarted.

**Readiness Probe:** Once the initial delay is complete, the probe starts checking the application's readiness every 3 seconds (`periodSeconds`). If the probe fails consecutively until the `failureThreshold` (usually 1), the pod is marked as "Not Ready" and excluded from service traffic.

**Once both probes report success (within their own intervals):** The pod transitions to the "Running" state and becomes available for traffic.

**Note:** The probes operate independently after the startup probe succeeds. Their individual `initialDelaySeconds` and `periodSeconds` determine their specific behavior and timing.
