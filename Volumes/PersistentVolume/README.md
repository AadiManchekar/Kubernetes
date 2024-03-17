k api-resources

- pvc is namespace
- pv is not namespace
- storageClass is not namespace

### Access Mode:
- ReadWriteOnce: R-W access by single node
- ReadOnlyMany: R-only access by many nodes
- ReadWriteMany: R-W access by many nodes
- ReadWriteOncePod: R/W access mounted by a single pod

### Reclaim Policy:
What should happen to PersistentVolume when Claim is deleted?
- Retain: Default. When PVC is deleted, PV is "released" and can be reclaimed
- Delete: Deletion removes the PV and associated storage.


Static:
In static the k8s admin has to create a pv and then developers create deployment and pvc

`storageClassName: ""` Assign an empty storage class name to use a statically created PersistentVolume

k apply -f pv.yaml
k apply -f pvc.yaml
k apply -f deployment.yaml
