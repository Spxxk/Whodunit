In mathematics, an integral is the continuous analog of a sum, which is used to calculate areas, volumes, and their generalizations. Integration, the process of computing an integral, is one of the two fundamental operations of calculus,[a] the other being differentiation. Integration started as a method to solve problems in mathematics and physics, such as finding the area under a curve, or determining displacement from velocity. Today integration is used in a wide variety of scientific fields.

The integrals enumerated here are those termed definite integrals, which can be interpreted as the signed area of the region in the plane that is bounded by the graph of a given function between two points in the real line. Conventionally, areas above the horizontal axis of the plane are positive while areas below are negative. Integrals also refer to the concept of an antiderivative, a function whose derivative is the given function; in this case, they are also called indefinite integrals. The fundamental theorem of calculus relates definite integrals with differentiation and provides a method to compute the definite integral of a function when its antiderivative is known.

Although methods of calculating areas and volumes dated from ancient Greek mathematics, the principles of integration were formulated independently by Isaac Newton and Gottfried Wilhelm Leibniz in the late 17th century, who thought of the area under a curve as an infinite sum of rectangles of infinitesimal width. Bernhard Riemann later gave a rigorous definition of integrals, which is based on a limiting procedure that approximates the area of a curvilinear region by breaking the region into infinitesimally thin vertical slabs. In the early 20th century, Henri Lebesgue generalized Riemann's formulation by introducing what is now referred to as the Lebesgue integral; it is more robust than Riemann's in the sense that a wider class of functions are Lebesgue-integrable.

Integrals may be generalized depending on the type of the function as well as the domain over which the integration is performed. For example, a line integral is defined for functions of two or more variables, and the interval of integration is replaced by a curve connecting the two endpoints of the interval. In a surface integral, the curve is replaced by a piece of a surface in three-dimensional space.

History
See also: History of calculus
Pre-calculus integration
The first documented systematic technique capable of determining integrals is the method of exhaustion of the ancient Greek astronomer Eudoxus (ca. 370 BC), which sought to find areas and volumes by breaking them up into an infinite number of divisions for which the area or volume was known.[1] This method was further developed and employed by Archimedes in the 3rd century BC and used to calculate the area of a circle, the surface area and volume of a sphere, area of an ellipse, the area under a parabola, the volume of a segment of a paraboloid of revolution, the volume of a segment of a hyperboloid of revolution, and the area of a spiral.[2]

A similar method was independently developed in China around the 3rd century AD by Liu Hui, who used it to find the area of the circle. This method was later used in the 5th century by Chinese father-and-son mathematicians Zu Chongzhi and Zu Geng to find the volume of a sphere.[3]

In the Middle East, Hasan Ibn al-Haytham, Latinized as Alhazen (c. 965 – c. 1040 AD) derived a formula for the sum of fourth powers.[4] He used the results to carry out what would now be called an integration of this function, where the formulae for the sums of integral squares and fourth powers allowed him to calculate the volume of a paraboloid.[5]

The next significant advances in integral calculus did not begin to appear until the 17th century. At this time, the work of Cavalieri with his method of Indivisibles, and work by Fermat, began to lay the foundations of modern calculus,[6] with Cavalieri computing the integrals of xn up to degree n = 9 in Cavalieri's quadrature formula.[7] The case n = −1 required the invention of a function, hyperbolic logarithm, achieved by quadrature of the hyperbola in 1647.

Further steps were made in the early 17th century by Barrow and Torricelli, who provided the first hints of a connection between integration and differentiation. Barrow provided the first proof of the fundamental theorem of calculus.[8] Wallis generalized Cavalieri's method, computing integrals of x to a general power, including negative powers and fractional powers.[9]

Leibniz and Newton
The major advance in integration came in the 17th century with the independent discovery of the fundamental theorem of calculus by Leibniz and Newton.[10] The theorem demonstrates a connection between integration and differentiation. This connection, combined with the comparative ease of differentiation, can be exploited to calculate integrals. In particular, the fundamental theorem of calculus allows one to solve a much broader class of problems. Equal in importance is the comprehensive mathematical framework that both Leibniz and Newton developed. Given the name infinitesimal calculus, it allowed for precise analysis of functions within continuous domains. This framework eventually became modern calculus, whose notation for integrals is drawn directly from the work of Leibniz.

Formalization
While Newton and Leibniz provided a systematic approach to integration, their work lacked a degree of rigour. Bishop Berkeley memorably attacked the vanishing increments used by Newton, calling them "ghosts of departed quantities".[11] Calculus acquired a firmer footing with the development of limits. Integration was first rigorously formalized, using limits, by Riemann.[12] Although all bounded piecewise continuous functions are Riemann-integrable on a bounded interval, subsequently more general functions were considered—particularly in the context of Fourier analysis—to which Riemann's definition does not apply, and Lebesgue formulated a different definition of integral, founded in measure theory (a subfield of real analysis). Other definitions of integral, extending Riemann's and Lebesgue's approaches, were proposed. These approaches based on the real number system are the ones most common today, but alternative approaches exist, such as a definition of integral as the standard part of an infinite Riemann sum, based on the hyperreal number system.

Historical notation
The notation for the indefinite integral was introduced by Gottfried Wilhelm Leibniz in 1675.[13] He adapted the integral symbol, ∫, from the letter ſ (long s), standing for summa (written as ſumma; Latin for "sum" or "total"). The modern notation for the definite integral, with limits above and below the integral sign, was first used by Joseph Fourier in Mémoires of the French Academy around 1819–1820, reprinted in his book of 1822.[14]

Isaac Newton used a small vertical bar above a variable to indicate integration, or placed the variable inside a box. The vertical bar was easily confused with 
.
x
 or x′, which are used to indicate differentiation, and the box notation was difficult for printers to reproduce, so these notations were not widely adopted.[15]

First use of the term
The term was first printed in Latin by Jacob Bernoulli in 1690: "Ergo et horum Integralia aequantur".[16]

Terminology and notation
In general, the integral of a real-valued function f(x) with respect to a real variable x on an interval [a, b] is written as

∫
�
�
�
(
�
)
d
�
.
{\displaystyle \int _{a}^{b}f(x)\,\mathrm {d} x.}
The integral sign ∫ represents integration. The symbol dx, called the differential of the variable x, indicates that the variable of integration is x. According to the standard ISO 80000-2:2019, the differential symbol should be printed in Roman (upright) style as it is an operator and not a variable. The function f(x) is called the integrand, the points a and b are called the limits (or bounds) of integration, and the integral is said to be over the interval [a, b], called the interval of integration.[17] A function is said to be integrable if its integral over its domain is finite. If limits are specified, the integral is called a definite integral.

When the limits are omitted, as in

∫
�
(
�
)
d
�
,
{\displaystyle \int f(x)\,\mathrm {d} x,}
the integral is called an indefinite integral, which represents a class of functions (the antiderivative) whose derivative is the integrand.[18] The fundamental theorem of calculus relates the evaluation of definite integrals to indefinite integrals. There are several extensions of the notation for integrals to encompass integration on unbounded domains and/or in multiple dimensions (see later sections of this article).

In advanced settings, it is not uncommon to leave out dx when only the simple Riemann integral is being used, or the exact type of integral is immaterial. For instance, one might write 
∫
�
�
(
�
1
�
+
�
2
�
)
=
�
1
∫
�
�
�
+
�
2
∫
�
�
�
{\textstyle \int _{a}^{b}(c_{1}f+c_{2}g)=c_{1}\int _{a}^{b}f+c_{2}\int _{a}^{b}g} to express the linearity of the integral, a property shared by the Riemann integral and all generalizations thereof.[19]

Interpretations

Approximations to integral of √x from 0 to 1, with 5 yellow right endpoint partitions and 12 green left endpoint partitions
Integrals appear in many practical situations. For instance, from the length, width and depth of a swimming pool which is rectangular with a flat bottom, one can determine the volume of water it can contain, the area of its surface, and the length of its edge. But if it is oval with a rounded bottom, integrals are required to find exact and rigorous values for these quantities. In each case, one may divide the sought quantity into infinitely many infinitesimal pieces, then sum the pieces to achieve an accurate approximation.

For example, to find the area of the region bounded by the graph of the function f(x) = √x between x = 0 and x = 1, one can cross the interval in five steps (0, 1/5, 2/5, ..., 1), then fill a rectangle using the right end height of each piece (thus √0, √1/5, √2/5, ..., √1) and sum their areas to get an approximation of

1
5
(
1
5
−
0
)
+
2
5
(
2
5
−
1
5
)
+
⋯
+
5
5
(
5
5
−
4
5
)
≈
0.7497
,
{\displaystyle \textstyle {\sqrt {\frac {1}{5}}}\left({\frac {1}{5}}-0\right)+{\sqrt {\frac {2}{5}}}\left({\frac {2}{5}}-{\frac {1}{5}}\right)+\cdots +{\sqrt {\frac {5}{5}}}\left({\frac {5}{5}}-{\frac {4}{5}}\right)\approx 0.7497,}
which is larger than the exact value. Alternatively, when replacing these subintervals by ones with the left end height of each piece, the approximation one gets is too low: with twelve such subintervals the approximated area is only 0.6203. However, when the number of pieces increases to infinity, it will reach a limit which is the exact value of the area sought (in this case, 2/3). One writes

∫
0
1
�
�
�
=
2
3
,
{\displaystyle \int _{0}^{1}{\sqrt {x}}\,dx={\frac {2}{3}},}
which means 2/3 is the result of a weighted sum of function values, √x, multiplied by the infinitesimal step widths, denoted by dx, on the interval [0, 1].

Darboux sums
Upper Darboux sum example
Darboux upper sums of the function y = x2
Lower Darboux sum example
Darboux lower sums of the function y = x2
Formal definitions
Riemann sum convergence
Riemann sums converging
There are many ways of formally defining an integral, not all of which are equivalent. The differences exist mostly to deal with differing special cases which may not be integrable under other definitions, but also occasionally for pedagogical reasons. The most commonly used definitions are Riemann integrals and Lebesgue integrals.

Riemann integral
Main article: Riemann integral
The Riemann integral is defined in terms of Riemann sums of functions with respect to tagged partitions of an interval.[20] A tagged partition of a closed interval [a, b] on the real line is a finite sequence

�
=
�
0
≤
�
1
≤
�
1
≤
�
2
≤
�
2
≤
⋯
≤
�
�
−
1
≤
�
�
≤
�
�
=
�
.
a=x_{0}\leq t_{1}\leq x_{1}\leq t_{2}\leq x_{2}\leq \cdots \leq x_{n-1}\leq t_{n}\leq x_{n}=b.\,\!
This partitions the interval [a, b] into n sub-intervals [xi−1, xi] indexed by i, each of which is "tagged" with a distinguished point ti ∈ [xi−1, xi]. A Riemann sum of a function f with respect to such a tagged partition is defined as

∑
�
=
1
�
�
(
�
�
)
Δ
�
;
{\displaystyle \sum _{i=1}^{n}f(t_{i})\,\Delta _{i};}
thus each term of the sum is the area of a rectangle with height equal to the function value at the distinguished point of the given sub-interval, and width the same as the width of sub-interval, Δi = xi−xi−1. The mesh of such a tagged partition is the width of the largest sub-interval formed by the partition, maxi=1...n Δi. The Riemann integral of a function f over the interval [a, b] is equal to S if:[21]

For all 
�
>
0
\varepsilon >0 there exists 
�
>
0
\delta >0 such that, for any tagged partition 
[
�
,
�
]
[a,b] with mesh less than 
�\delta ,
|
�
−
∑
�
=
1
�
�
(
�
�
)
Δ
�
|
<
�
.
{\displaystyle \left|S-\sum _{i=1}^{n}f(t_{i})\,\Delta _{i}\right|<\varepsilon .}
When the chosen tags give the maximum (respectively, minimum) value of each interval, the Riemann sum becomes an upper (respectively, lower) Darboux sum, suggesting the close connection between the Riemann integral and the Darboux integral.

Lebesgue integral
Main article: Lebesgue integration
Comparison of Riemann and Lebesgue integrals
Riemann–Darboux's integration (top) and Lebesgue integration (bottom)
It is often of interest, both in theory and applications, to be able to pass to the limit under the integral. For instance, a sequence of functions can frequently be constructed that approximate, in a suitable sense, the solution to a problem. Then the integral of the solution function should be the limit of the integrals of the approximations. However, many functions that can be obtained as limits are not Riemann-integrable, and so such limit theorems do not hold with the Riemann integral. Therefore, it is of great importance to have a definition of the integral that allows a wider class of functions to be integrated.[22]

Such an integral is the Lebesgue integral, that exploits the following fact to enlarge the class of integrable functions: if the values of a function are rearranged over the domain, the integral of a function should remain the same. Thus Henri Lebesgue introduced the integral bearing his name, explaining this integral thus in a letter to Paul Montel:[23]

I have to pay a certain sum, which I have collected in my pocket. I take the bills and coins out of my pocket and give them to the creditor in the order I find them until I have reached the total sum. This is the Riemann integral. But I can proceed differently. After I have taken all the money out of my pocket I order the bills and coins according to identical values and then I pay the several heaps one after the other to the creditor. This is my integral.

As Folland puts it, "To compute the Riemann integral of f, one partitions the domain [a, b] into subintervals", while in the Lebesgue integral, "one is in effect partitioning the range of f ".[24] The definition of the Lebesgue integral thus begins with a measure, μ. In the simplest case, the Lebesgue measure μ(A) of an interval A = [a, b] is its width, b − a, so that the Lebesgue integral agrees with the (proper) Riemann integral when both exist.[25] In more complicated cases, the sets being measured can be highly fragmented, with no continuity and no resemblance to intervals.

Using the "partitioning the range of f " philosophy, the integral of a non-negative function f : R → R should be the sum over t of the areas between a thin horizontal strip between y = t and y = t + dt. This area is just μ{ x : f(x) > t} dt. Let f∗(t) = μ{ x : f(x) > t }. The Lebesgue integral of f is then defined by

∫
�
=
∫
0
∞
�
∗
(
�
)
�
�
\int f=\int _{0}^{\infty }f^{*}(t)\,dt
where the integral on the right is an ordinary improper Riemann integral (f∗ is a strictly decreasing positive function, and therefore has a well-defined improper Riemann integral).[26] For a suitable class of functions (the measurable functions) this defines the Lebesgue integral.

A general measurable function f is Lebesgue-integrable if the sum of the absolute values of the areas of the regions between the graph of f and the x-axis is finite:[27]

∫
�
|
�
|
�
�
<
+
∞
.
\int _{E}|f|\,d\mu <+\infty .
In that case, the integral is, as in the Riemannian case, the difference between the area above the x-axis and the area below the x-axis:[28]

∫
�
�
�
�
=
∫
�
�
+
�
�
−
∫
�
�
−
�
�\int _{E}f\,d\mu =\int _{E}f^{+}\,d\mu -\int _{E}f^{-}\,d\mu 
where

�
+
(
�
)
=
max
{
�
(
�
)
,
0
}
=
{
�
(
�
)
,
if 
�
(
�
)
>
0
,
0
,
otherwise,
�
−
(
�
)
=
max
{
−
�
(
�
)
,
0
}
=
{
−
�
(
�
)
,
if 
�
(
�
)
<
0
,
0
,
otherwise.
{\displaystyle {\begin{alignedat}{3}&f^{+}(x)&&{}={}\max\{f(x),0\}&&{}={}{\begin{cases}f(x),&{\text{if }}f(x)>0,\\0,&{\text{otherwise,}}\end{cases}}\\&f^{-}(x)&&{}={}\max\{-f(x),0\}&&{}={}{\begin{cases}-f(x),&{\text{if }}f(x)<0,\\0,&{\text{otherwise.}}\end{cases}}\end{alignedat}}}
Other integrals
Although the Riemann and Lebesgue integrals are the most widely used definitions of the integral, a number of others exist, including:

The Darboux integral, which is defined by Darboux sums (restricted Riemann sums) yet is equivalent to the Riemann integral. A function is Darboux-integrable if and only if it is Riemann-integrable. Darboux integrals have the advantage of being easier to define than Riemann integrals.
The Riemann–Stieltjes integral, an extension of the Riemann integral which integrates with respect to a function as opposed to a variable.
The Lebesgue–Stieltjes integral, further developed by Johann Radon, which generalizes both the Riemann–Stieltjes and Lebesgue integrals.
The Daniell integral, which subsumes the Lebesgue integral and Lebesgue–Stieltjes integral without depending on measures.
The Haar integral, used for integration on locally compact topological groups, introduced by Alfréd Haar in 1933.
The Henstock–Kurzweil integral, variously defined by Arnaud Denjoy, Oskar Perron, and (most elegantly, as the gauge integral) Jaroslav Kurzweil, and developed by Ralph Henstock.
The Itô integral and Stratonovich integral, which define integration with respect to semimartingales such as Brownian motion.
The Young integral, which is a kind of Riemann–Stieltjes integral with respect to certain functions of unbounded variation.
The rough path integral, which is defined for functions equipped with some additional "rough path" structure and generalizes stochastic integration against both semimartingales and processes such as the fractional Brownian motion.
The Choquet integral, a subadditive or superadditive integral created by the French mathematician Gustave Choquet in 1953.
The Bochner integral, an extension of the Lebesgue integral to a more general class of functions, namely, those with a domain that is a Banach space.
Properties
Linearity
The collection of Riemann-integrable functions on a closed interval [a, b] forms a vector space under the operations of pointwise addition and multiplication by a scalar, and the operation of integration

�
↦
∫
�
�
�
(
�
)
�
�
f\mapsto \int _{a}^{b}f(x)\;dx
is a linear functional on this vector space. Thus, the collection of integrable functions is closed under taking linear combinations, and the integral of a linear combination is the linear combination of the integrals:[29]

∫
�
�
(
�
�
+
�
�
)
(
�
)
�
�
=
�
∫
�
�
�
(
�
)
�
�
+
�
∫
�
�
�
(
�
)
�
�
.
\int _{a}^{b}(\alpha f+\beta g)(x)\,dx=\alpha \int _{a}^{b}f(x)\,dx+\beta \int _{a}^{b}g(x)\,dx.\,
Similarly, the set of real-valued Lebesgue-integrable functions on a given measure space E with measure μ is closed under taking linear combinations and hence form a vector space, and the Lebesgue integral

�
↦
∫
�
�
�
�f\mapsto \int _{E}f\,d\mu 
is a linear functional on this vector space, so that:[28]

∫
�
(
�
�
+
�
�
)
�
�
=
�
∫
�
�
�
�
+
�
∫
�
�
�
�
.
\int _{E}(\alpha f+\beta g)\,d\mu =\alpha \int _{E}f\,d\mu +\beta \int _{E}g\,d\mu .
More generally, consider the vector space of all measurable functions on a measure space (E,μ), taking values in a locally compact complete topological vector space V over a locally compact topological field K, f : E → V. Then one may define an abstract integration map assigning to each function f an element of V or the symbol ∞,

�
↦
∫
�
�
�
�
,
f\mapsto \int _{E}f\,d\mu ,\,
that is compatible with linear combinations.[30] In this situation, the linearity holds for the subspace of functions whose integral is an element of V (i.e. "finite"). The most important special cases arise when K is R, C, or a finite extension of the field Qp of p-adic numbers, and V is a finite-dimensional vector space over K, and when K = C and V is a complex Hilbert space.

Linearity, together with some natural continuity properties and normalization for a certain class of "simple" functions, may be used to give an alternative definition of the integral. This is the approach of Daniell for the case of real-valued functions on a set X, generalized by Nicolas Bourbaki to functions with values in a locally compact topological vector space. See Hildebrandt 1953 for an axiomatic characterization of the integral.

Inequalities
A number of general inequalities hold for Riemann-integrable functions defined on a closed and bounded interval [a, b] and can be generalized to other notions of integral (Lebesgue and Daniell).

Upper and lower bounds. An integrable function f on [a, b], is necessarily bounded on that interval. Thus there are real numbers m and M so that m ≤ f (x) ≤ M for all x in [a, b]. Since the lower and upper sums of f over [a, b] are therefore bounded by, respectively, m(b − a) and M(b − a), it follows that
�
(
�
−
�
)
≤
∫
�
�
�
(
�
)
�
�
≤
�
(
�
−
�
)
.
{\displaystyle m(b-a)\leq \int _{a}^{b}f(x)\,dx\leq M(b-a).}
Inequalities between functions.[31] If f(x) ≤ g(x) for each x in [a, b] then each of the upper and lower sums of f is bounded above by the upper and lower sums, respectively, of g. Thus
∫
�
�
�
(
�
)
�
�
≤
∫
�
�
�
(
�
)
�
�
.
{\displaystyle \int _{a}^{b}f(x)\,dx\leq \int _{a}^{b}g(x)\,dx.}
This is a generalization of the above inequalities, as M(b − a) is the integral of the constant function with value M over [a, b]. In addition, if the inequality between functions is strict, then the inequality between integrals is also strict. That is, if f(x) < g(x) for each x in [a, b], then
∫
�
�
�
(
�
)
�
�
<
∫
�
�
�
(
�
)
�
�
.
{\displaystyle \int _{a}^{b}f(x)\,dx<\int _{a}^{b}g(x)\,dx.}
Subintervals. If [c, d] is a subinterval of [a, b] and f (x) is non-negative for all x, then
∫
�
�
�
(
�
)
�
�
≤
∫
�
�
�
(
�
)
�
�
.
{\displaystyle \int _{c}^{d}f(x)\,dx\leq \int _{a}^{b}f(x)\,dx.}
Products and absolute values of functions. If f and g are two functions, then we may consider their pointwise products and powers, and absolute values:
(
�
�
)
(
�
)
=
�
(
�
)
�
(
�
)
,
�
2
(
�
)
=
(
�
(
�
)
)
2
,
|
�
|
(
�
)
=
|
�
(
�
)
|
.
{\displaystyle (fg)(x)=f(x)g(x),\;f^{2}(x)=(f(x))^{2},\;|f|(x)=|f(x)|.}
If f is Riemann-integrable on [a, b] then the same is true for |f|, and
|
∫
�
�
�
(
�
)
�
�
|
≤
∫
�
�
|
�
(
�
)
|
�
�
.
{\displaystyle \left|\int _{a}^{b}f(x)\,dx\right|\leq \int _{a}^{b}|f(x)|\,dx.}
Moreover, if f and g are both Riemann-integrable then fg is also Riemann-integrable, and
(
∫
�
�
(
�
�
)
(
�
)
�
�
)
2
≤
(
∫
�
�
�
(
�
)
2
�
�
)
(
∫
�
�
�
(
�
)
2
�
�
)
.
{\displaystyle \left(\int _{a}^{b}(fg)(x)\,dx\right)^{2}\leq \left(\int _{a}^{b}f(x)^{2}\,dx\right)\left(\int _{a}^{b}g(x)^{2}\,dx\right).}
This inequality, known as the Cauchy–Schwarz inequality, plays a prominent role in Hilbert space theory, where the left hand side is interpreted as the inner product of two square-integrable functions f and g on the interval [a, b].
Hölder's inequality.[32] Suppose that p and q are two real numbers, 1 ≤ p, q ≤ ∞ with 
1
/
p
 + 
1
/
q
 = 1, and f and g are two Riemann-integrable functions. Then the functions |f|p and |g|q are also integrable and the following Hölder's inequality holds:
|
∫
�
(
�
)
�
(
�
)
�
�
|
≤
(
∫
|
�
(
�
)
|
�
�
�
)
1
/
�
(
∫
|
�
(
�
)
|
�
�
�
)
1
/
�
.
{\displaystyle \left|\int f(x)g(x)\,dx\right|\leq \left(\int \left|f(x)\right|^{p}\,dx\right)^{1/p}\left(\int \left|g(x)\right|^{q}\,dx\right)^{1/q}.}
For p = q = 2, Hölder's inequality becomes the Cauchy–Schwarz inequality.
Minkowski inequality.[32] Suppose that p ≥ 1 is a real number and f and g are Riemann-integrable functions. Then | f |p, | g |p and | f + g |p are also Riemann-integrable and the following Minkowski inequality holds:
(
∫
|
�
(
�
)
+
�
(
�
)
|
�
�
�
)
1
/
�
≤
(
∫
|
�
(
�
)
|
�
�
�
)
1
/
�
+
(
∫
|
�
(
�
)
|
�
�
�
)
1
/
�
.
{\displaystyle \left(\int \left|f(x)+g(x)\right|^{p}\,dx\right)^{1/p}\leq \left(\int \left|f(x)\right|^{p}\,dx\right)^{1/p}+\left(\int \left|g(x)\right|^{p}\,dx\right)^{1/p}.}
An analogue of this inequality for Lebesgue integral is used in construction of Lp spaces.
Conventions
In this section, f is a real-valued Riemann-integrable function. The integral

∫
�
�
�
(
�
)
�
�
\int _{a}^{b}f(x)\,dx
over an interval [a, b] is defined if a < b. This means that the upper and lower sums of the function f are evaluated on a partition a = x0 ≤ x1 ≤ . . . ≤ xn = b whose values xi are increasing. Geometrically, this signifies that integration takes place "left to right", evaluating f within intervals [x i , x i +1] where an interval with a higher index lies to the right of one with a lower index. The values a and b, the end-points of the interval, are called the limits of integration of f. Integrals can also be defined if a > b:[17]

∫
�
�
�
(
�
)
�
�
=
−
∫
�
�
�
(
�
)
�
�
.
\int _{a}^{b}f(x)\,dx=-\int _{b}^{a}f(x)\,dx.
With a = b, this implies:

∫
�
�
�
(
�
)
�
�
=
0.
\int _{a}^{a}f(x)\,dx=0.
The first convention is necessary in consideration of taking integrals over subintervals of [a, b]; the second says that an integral taken over a degenerate interval, or a point, should be zero. One reason for the first convention is that the integrability of f on an interval [a, b] implies that f is integrable on any subinterval [c, d], but in particular integrals have the property that if c is any element of [a, b], then:[29]

∫
�
�
�
(
�
)
�
�
=
∫
�
�
�
(
�
)
�
�
+
∫
�
�
�
(
�
)
�
�
.
\int _{a}^{b}f(x)\,dx=\int _{a}^{c}f(x)\,dx+\int _{c}^{b}f(x)\,dx.
With the first convention, the resulting relation

∫
�
�
�
(
�
)
�
�
=
∫
�
�
�
(
�
)
�
�
−
∫
�
�
�
(
�
)
�
�
=
∫
�
�
�
(
�
)
�
�
+
∫
�
�
�
(
�
)
�
�
{\begin{aligned}\int _{a}^{c}f(x)\,dx&{}=\int _{a}^{b}f(x)\,dx-\int _{c}^{b}f(x)\,dx\\&{}=\int _{a}^{b}f(x)\,dx+\int _{b}^{c}f(x)\,dx\end{aligned}}
is then well-defined for any cyclic permutation of a, b, and c.

Fundamental theorem of calculus
Main article: Fundamental theorem of calculus
The fundamental theorem of calculus is the statement that differentiation and integration are inverse operations: if a continuous function is first integrated and then differentiated, the original function is retrieved.[33] An important consequence, sometimes called the second fundamental theorem of calculus, allows one to compute integrals by using an antiderivative of the function to be integrated.[34]

First theorem
Let f be a continuous real-valued function defined on a closed interval [a, b]. Let F be the function defined, for all x in [a, b], by[35]

�
(
�
)
=
∫
�
�
�
(
�
)
�
�
.
F(x)=\int _{a}^{x}f(t)\,dt.
Then, F is continuous on [a, b], differentiable on the open interval (a, b), and

�
′
(
�
)
=
�
(
�
)
F'(x)=f(x)
for all x in (a, b).

Second theorem
Let f be a real-valued function defined on a closed interval [a, b] that admits an antiderivative F on [a, b]. That is, f and F are functions such that for all x in [a, b],

�
(
�
)
=
�
′
(
�
)
.
f(x)=F'(x).
If f is integrable on [a, b] then

∫
�
�
�
(
�
)
�
�
=
�
(
�
)
−
�
(
�
)
.
\int _{a}^{b}f(x)\,dx=F(b)-F(a).
Extensions
Improper integrals
Main article: Improper integral

The improper integral
∫
0
∞
�
�
(
�
+
1
)
�
=
�\int _{0}^{\infty }{\frac {dx}{(x+1){\sqrt {x}}}}=\pi  has unbounded intervals for both domain and range.
A "proper" Riemann integral assumes the integrand is defined and finite on a closed and bounded interval, bracketed by the limits of integration. An improper integral occurs when one or more of these conditions is not satisfied. In some cases such integrals may be defined by considering the limit of a sequence of proper Riemann integrals on progressively larger intervals.

If the interval is unbounded, for instance at its upper end, then the improper integral is the limit as that endpoint goes to infinity:[36]

∫
�
∞
�
(
�
)
�
�
=
lim
�
→
∞
∫
�
�
�
(
�
)
�
�
.
{\displaystyle \int _{a}^{\infty }f(x)\,dx=\lim _{b\to \infty }\int _{a}^{b}f(x)\,dx.}
If the integrand is only defined or finite on a half-open interval, for instance (a, b], then again a limit may provide a finite result:[37]

∫
�
�
�
(
�
)
�
�
=
lim
�
→
0
∫
�
+
�
�
�
(
�
)
�
�
.
{\displaystyle \int _{a}^{b}f(x)\,dx=\lim _{\varepsilon \to 0}\int _{a+\epsilon }^{b}f(x)\,dx.}
That is, the improper integral is the limit of proper integrals as one endpoint of the interval of integration approaches either a specified real number, or ∞, or −∞. In more complicated cases, limits are required at both endpoints, or at interior points.

Multiple integration
Main article: Multiple integral

Double integral computes volume under a surface 
�
=
�
(
�
,
�
)
z=f(x,y)
Just as the definite integral of a positive function of one variable represents the area of the region between the graph of the function and the x-axis, the double integral of a positive function of two variables represents the volume of the region between the surface defined by the function and the plane that contains its domain.[38] For example, a function in two dimensions depends on two real variables, x and y, and the integral of a function f over the rectangle R given as the Cartesian product of two intervals 
�
=
[
�
,
�
]
×
[
�
,
�
]
R=[a,b]\times [c,d] can be written

∫
�
�
(
�
,
�
)
�
�
\int _{R}f(x,y)\,dA
where the differential dA indicates that integration is taken with respect to area. This double integral can be defined using Riemann sums, and represents the (signed) volume under the graph of z = f(x,y) over the domain R.[39] Under suitable conditions (e.g., if f is continuous), Fubini's theorem states that this integral can be expressed as an equivalent iterated integral[40]

∫
�
�
[
∫
�
�
�
(
�
,
�
)
�
�
]
�
�
.
\int _{a}^{b}\left[\int _{c}^{d}f(x,y)\,dy\right]\,dx.
This reduces the problem of computing a double integral to computing one-dimensional integrals. Because of this, another notation for the integral over R uses a double integral sign:[39]

∬
�
�
(
�
,
�
)
�
�
.
{\displaystyle \iint _{R}f(x,y)\,dA.}
Integration over more general domains is possible. The integral of a function f, with respect to volume, over an n-dimensional region D of 
�
�
\mathbb {R} ^{n} is denoted by symbols such as:

∫
�
�
(
�
)
�
�
�
 
=
∫
�
�
�
�
.
{\displaystyle \int _{D}f(\mathbf {x} )d^{n}\mathbf {x} \ =\int _{D}f\,dV.}
Line integrals and surface integrals
Main articles: Line integral and Surface integral

A line integral sums together elements along a curve.
The concept of an integral can be extended to more general domains of integration, such as curved lines and surfaces inside higher-dimensional spaces. Such integrals are known as line integrals and surface integrals respectively. These have important applications in physics, as when dealing with vector fields.

A line integral (sometimes called a path integral) is an integral where the function to be integrated is evaluated along a curve.[41] Various different line integrals are in use. In the case of a closed curve it is also called a contour integral.

The function to be integrated may be a scalar field or a vector field. The value of the line integral is the sum of values of the field at all points on the curve, weighted by some scalar function on the curve (commonly arc length or, for a vector field, the scalar product of the vector field with a differential vector in the curve).[42] This weighting distinguishes the line integral from simpler integrals defined on intervals. Many simple formulas in physics have natural continuous analogs in terms of line integrals; for example, the fact that work is equal to force, F, multiplied by displacement, s, may be expressed (in terms of vector quantities) as:[43]

�
=
�
⋅
�
.
W=\mathbf {F} \cdot \mathbf {s} .
For an object moving along a path C in a vector field F such as an electric field or gravitational field, the total work done by the field on the object is obtained by summing up the differential work done in moving from s to s + ds. This gives the line integral[44]

�
=
∫
�
�
⋅
�
�
.
W=\int _{C}\mathbf {F} \cdot d\mathbf {s} .

The definition of surface integral relies on splitting the surface into small surface elements.
A surface integral generalizes double integrals to integration over a surface (which may be a curved set in space); it can be thought of as the double integral analog of the line integral. The function to be integrated may be a scalar field or a vector field. The value of the surface integral is the sum of the field at all points on the surface. This can be achieved by splitting the surface into surface elements, which provide the partitioning for Riemann sums.[45]

For an example of applications of surface integrals, consider a vector field v on a surface S; that is, for each point x in S, v(x) is a vector. Imagine that a fluid flows through S, such that v(x) determines the velocity of the fluid at x. The flux is defined as the quantity of fluid flowing through S in unit amount of time. To find the flux, one need to take the dot product of v with the unit surface normal to S at each point, which will give a scalar field, which is integrated over the surface:[46]

∫
�
�
⋅
�
�
.
{\displaystyle \int _{S}{\mathbf {v} }\cdot \,d{\mathbf {S} }.}
The fluid flux in this example may be from a physical fluid such as water or air, or from electrical or magnetic flux. Thus surface integrals have applications in physics, particularly with the classical theory of electromagnetism.

Contour integrals
Main article: Contour integration
In complex analysis, the integrand is a complex-valued function of a complex variable z instead of a real function of a real variable x. When a complex function is integrated along a curve 
�\gamma  in the complex plane, the integral is denoted as follows

∫
�
�
(
�
)
�
�
.
{\displaystyle \int _{\gamma }f(z)\,dz.}
This is known as a contour integral.

Integrals of differential forms
Main article: Differential form
See also: Volume form and Density on a manifold
A differential form is a mathematical concept in the fields of multivariable calculus, differential topology, and tensors. Differential forms are organized by degree. For example, a one-form is a weighted sum of the differentials of the coordinates, such as:

�
(
�
,
�
,
�
)
�
�
+
�
(
�
,
�
,
�
)
�
�
+
�
(
�
,
�
,
�
)
�
�
E(x,y,z)\,dx+F(x,y,z)\,dy+G(x,y,z)\,dz
where E, F, G are functions in three dimensions. A differential one-form can be integrated over an oriented path, and the resulting integral is just another way of writing a line integral. Here the basic differentials dx, dy, dz measure infinitesimal oriented lengths parallel to the three coordinate axes.

A differential two-form is a sum of the form

�
(
�
,
�
,
�
)
�
�
∧
�
�
+
�
(
�
,
�
,
�
)
�
�
∧
�
�
+
�
(
�
,
�
,
�
)
�
�
∧
�
�
.
{\displaystyle G(x,y,z)\,dx\wedge dy+E(x,y,z)\,dy\wedge dz+F(x,y,z)\,dz\wedge dx.}
Here the basic two-forms 
�
�
∧
�
�
,
�
�
∧
�
�
,
�
�
∧
�
�
dx\wedge dy,dz\wedge dx,dy\wedge dz measure oriented areas parallel to the coordinate two-planes. The symbol 
∧\wedge  denotes the wedge product, which is similar to the cross product in the sense that the wedge product of two forms representing oriented lengths represents an oriented area. A two-form can be integrated over an oriented surface, and the resulting integral is equivalent to the surface integral giving the flux of 
�
�
+
�
�
+
�
�
E\mathbf {i} +F\mathbf {j} +G\mathbf {k} .

Unlike the cross product, and the three-dimensional vector calculus, the wedge product and the calculus of differential forms makes sense in arbitrary dimension and on more general manifolds (curves, surfaces, and their higher-dimensional analogs). The exterior derivative plays the role of the gradient and curl of vector calculus, and Stokes' theorem simultaneously generalizes the three theorems of vector calculus: the divergence theorem, Green's theorem, and the Kelvin-Stokes theorem.

Summations
Main article: Summation § Approximation by definite integrals
The discrete equivalent of integration is summation. Summations and integrals can be put on the same foundations using the theory of Lebesgue integrals or time-scale calculus.

Functional integrals
Main article: Functional integration
An integration that is performed not over a variable (or, in physics, over a space or time dimension), but over a space of functions, is referred to as a functional integral.

Applications
Integrals are used extensively in many areas. For example, in probability theory, integrals are used to determine the probability of some random variable falling within a certain range.[47] Moreover, the integral under an entire probability density function must equal 1, which provides a test of whether a function with no negative values could be a density function or not.[48]

Integrals can be used for computing the area of a two-dimensional region that has a curved boundary, as well as computing the volume of a three-dimensional object that has a curved boundary. The area of a two-dimensional region can be calculated using the aforementioned definite integral.[49] The volume of a three-dimensional object such as a disc or washer can be computed by disc integration using the equation for the volume of a cylinder, 
�
�
2
ℎ
{\displaystyle \pi r^{2}h}, where 
�
r is the radius. In the case of a simple disc created by rotating a curve about the x-axis, the radius is given by f(x), and its height is the differential dx. Using an integral with bounds a and b, the volume of the disc is equal to:[50]

�
∫
�
�
�
2
(
�
)
�
�
.
{\displaystyle \pi \int _{a}^{b}f^{2}(x)\,dx.}
Integrals are also used in physics, in areas like kinematics to find quantities like displacement, time, and velocity. For example, in rectilinear motion, the displacement of an object over the time interval 
[
�
,
�
]
[a,b] is given by:
�
(
�
)
−
�
(
�
)
=
∫
�
�
�
(
�
)
�
�
,
{\displaystyle x(b)-x(a)=\int _{a}^{b}v(t)\,dt,}
where 
�
(
�
)
v(t) is the velocity expressed as a function of time.[51] The work done by a force 
�
(
�
)
F(x) (given as a function of position) from an initial position 
�
A to a final position 
�
B is:[52]

�
�
→
�
=
∫
�
�
�
(
�
)
�
�
.
{\displaystyle W_{A\rightarrow B}=\int _{A}^{B}F(x)\,dx.}
Integrals are also used in thermodynamics, where thermodynamic integration is used to calculate the difference in free energy between two given states.

Computation
Analytical
The most basic technique for computing definite integrals of one real variable is based on the fundamental theorem of calculus. Let f(x) be the function of x to be integrated over a given interval [a, b]. Then, find an antiderivative of f; that is, a function F such that F′ = f on the interval. Provided the integrand and integral have no singularities on the path of integration, by the fundamental theorem of calculus,

∫
�
�
�
(
�
)
�
�
=
�
(
�
)
−
�
(
�
)
.
{\displaystyle \int _{a}^{b}f(x)\,dx=F(b)-F(a).}
Sometimes it is necessary to use one of the many techniques that have been developed to evaluate integrals. Most of these techniques rewrite one integral as a different one which is hopefully more tractable. Techniques include integration by substitution, integration by parts, integration by trigonometric substitution, and integration by partial fractions.

Alternative methods exist to compute more complex integrals. Many nonelementary integrals can be expanded in a Taylor series and integrated term by term. Occasionally, the resulting infinite series can be summed analytically. The method of convolution using Meijer G-functions can also be used, assuming that the integrand can be written as a product of Meijer G-functions. There are also many less common ways of calculating definite integrals; for instance, Parseval's identity can be used to transform an integral over a rectangular region into an infinite sum. Occasionally, an integral can be evaluated by a trick; for an example of this, see Gaussian integral.

Computations of volumes of solids of revolution can usually be done with disk integration or shell integration.

Specific results which have been worked out by various techniques are collected in the list of integrals.

Symbolic
Main article: Symbolic integration
Many problems in mathematics, physics, and engineering involve integration where an explicit formula for the integral is desired. Extensive tables of integrals have been compiled and published over the years for this purpose. With the spread of computers, many professionals, educators, and students have turned to computer algebra systems that are specifically designed to perform difficult or tedious tasks, including integration. Symbolic integration has been one of the motivations for the development of the first such systems, like Macsyma and Maple.

A major mathematical difficulty in symbolic integration is that in many cases, a relatively simple function does not have integrals that can be expressed in closed form involving only elementary functions, include rational and exponential functions, logarithm, trigonometric functions and inverse trigonometric functions, and the operations of multiplication and composition. The Risch algorithm provides a general criterion to determine whether the antiderivative of an elementary function is elementary and to compute the integral if is elementary. However, functions with closed expressions of antiderivatives are the exception, and consequently, computerized algebra systems have no hope of being able to find an antiderivative for a randomly constructed elementary function. On the positive side, if the 'building blocks' for antiderivatives are fixed in advance, it may still be possible to decide whether the antiderivative of a given function can be expressed using these blocks and operations of multiplication and composition and to find the symbolic answer whenever it exists. The Risch algorithm, implemented in Mathematica, Maple and other computer algebra systems, does just that for functions and antiderivatives built from rational functions, radicals, logarithm, and exponential functions.

Some special integrands occur often enough to warrant special study. In particular, it may be useful to have, in the set of antiderivatives, the special functions (like the Legendre functions, the hypergeometric function, the gamma function, the incomplete gamma function and so on). Extending Risch's algorithm to include such functions is possible but challenging and has been an active research subject.

More recently a new approach has emerged, using D-finite functions, which are the solutions of linear differential equations with polynomial coefficients. Most of the elementary and special functions are D-finite, and the integral of a D-finite function is also a D-finite function. This provides an algorithm to express the antiderivative of a D-finite function as the solution of a differential equation. This theory also allows one to compute the definite integral of a D-function as the sum of a series given by the first coefficients and provides an algorithm to compute any coefficient.

Rule-based integration systems facilitate integration. Rubi, a computer algebra system rule-based integrator, pattern matches an extensive system of symbolic integration rules to integrate a wide variety of integrands. This system uses over 6600 integration rules to compute integrals.[53] The method of brackets is a generalization of Ramanujan's master theorem that can be applied to a wide range of univariate and multivariate integrals. A set of rules are applied to the coefficients and exponential terms of the integrand's power series expansion to determine the integral. The method is closely related to the Mellin transform.[54]

Numerical
Main article: Numerical integration

Numerical quadrature methods: rectangle method, trapezoidal rule, Romberg's method, Gaussian quadrature
Definite integrals may be approximated using several methods of numerical integration. The rectangle method relies on dividing the region under the function into a series of rectangles corresponding to function values and multiplies by the step width to find the sum. A better approach, the trapezoidal rule, replaces the rectangles used in a Riemann sum with trapezoids. The trapezoidal rule weights the first and last values by one half, then multiplies by the step width to obtain a better approximation.[55] The idea behind the trapezoidal rule, that more accurate approximations to the function yield better approximations to the integral, can be carried further: Simpson's rule approximates the integrand by a piecewise quadratic function.[56]

Riemann sums, the trapezoidal rule, and Simpson's rule are examples of a family of quadrature rules called the Newton–Cotes formulas. The degree n Newton–Cotes quadrature rule approximates the polynomial on each subinterval by a degree n polynomial. This polynomial is chosen to interpolate the values of the function on the interval.[57] Higher degree Newton–Cotes approximations can be more accurate, but they require more function evaluations, and they can suffer from numerical inaccuracy due to Runge's phenomenon. One solution to this problem is Clenshaw–Curtis quadrature, in which the integrand is approximated by expanding it in terms of Chebyshev polynomials.

Romberg's method halves the step widths incrementally, giving trapezoid approximations denoted by T(h0), T(h1), and so on, where hk+1 is half of hk. For each new step size, only half the new function values need to be computed; the others carry over from the previous size. It then interpolate a polynomial through the approximations, and extrapolate to T(0). Gaussian quadrature evaluates the function at the roots of a set of orthogonal polynomials.[58] An n-point Gaussian method is exact for polynomials of degree up to 2n − 1.

The computation of higher-dimensional integrals (for example, volume calculations) makes important use of such alternatives as Monte Carlo integration.[59]

Mechanical
The area of an arbitrary two-dimensional shape can be determined using a measuring instrument called planimeter. The volume of irregular objects can be measured with precision by the fluid displaced as the object is submerged.

Geometrical
Main article: Quadrature (mathematics)
Area can sometimes be found via geometrical compass-and-straightedge constructions of an equivalent square.

Integration by differentiation
Kempf, Jackson and Morales demonstrated mathematical relations that allow an integral to be calculated by means of differentiation. Their calculus involves the Dirac delta function and the partial derivative operator 
∂
�
\partial _{x}. This can also be applied to functional integrals, allowing them to be computed by functional differentiation.[60]

Examples
Using the Fundamental Theorem of Calculus
The fundamental theorem of calculus allows for straightforward calculations of basic functions.

∫
0
�
sin
⁡
(
�
)
�
�
=
−
cos
⁡
(
�
)
|
�
=
0
�
=
�
=
−
cos
⁡
(
�
)
−
(
−
cos
⁡
(
0
)
)
=
2
{\displaystyle \int _{0}^{\pi }\sin(x)dx=-\cos(x){\big |}_{x=0}^{x=\pi }=-\cos(\pi )-(-\cos(0))=2}
