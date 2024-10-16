import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D

# Generar la función f(x1, x2) = x1^2 + 0.5*x2^2
x = np.arange(-2.0, 2.0, 0.05)
x1, x2 = np.meshgrid(x, x)
y = x1**2 + 0.5 * x2**2

# Coordenadas obtenidas del gradiente descendente en Java (copiar de la salida del programa Java)
qt = [2.0, 3.0, 13.0, 1.8, 2.7, 10.2, 1.6, 2.5, 8.1, 1.2, 2.1, 4.3]  # Aquí pones los resultados de Java

# Reshape para tener las coordenadas del descenso de gradiente
qt = np.array(qt).reshape(-1, 3)

# Graficar la superficie
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')
ax.plot_surface(x1, x2, y, cmap='viridis', edgecolor='none', alpha=0.6)
ax.set_xlabel('x1')
ax.set_ylabel('x2')
ax.set_zlabel('f(x1, x2)')

# Graficar el descenso de gradiente
ax.plot(qt[:, 0], qt[:, 1], qt[:, 2], 'r.-', markersize=8, label='Gradient Descent Path')
plt.legend()
plt.show()

# Opcional: Graficar la vista de contorno 2D
plt.contour(x1, x2, y, levels=30)
plt.plot(qt[:, 0], qt[:, 1], 'ro-', label='Gradient Descent Path')
plt.xlabel('x1')
plt.ylabel('x2')
plt.legend()
plt.show()
