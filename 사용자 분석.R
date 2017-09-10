userid = c("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "scott")
movie = c(5,17,2,9,5,5,9,8,8,11,6,5,7,8,1,2,2,1,3,13,8,2,0,5,9,1,0)
variety = c(3,1,13,5,5,1,6,6,2,8,19,5,5,9,10,18,18,1,5,9,12,10,6,8,7,1,1)
news = c(15,7,12,1,7,5,7,2,8,1,10,13,6,6,10,15,16,16,18,13,8,7,0,3,0,6,2)
docu = c(4,6,15,8,8,6,8,5,9,6,18,3,2,8,9,14,15,3,6,1,9,9,8,2,10,9,9)
user_hit = data.frame(movie, variety, news, docu, userid)
user_hit
test = data.frame(movie, variety, news, docu)
test

summary(user_hit)

install.packages("reshape")
library(reshape)

a <- cast(user_hit, userid~.~movie)
a

install.packages("Hmisc")
library(Hmisc)

rcorr(as.matrix(test), type = "spearman")

pca <- princomp(test, cor = T)
summary(pca)
biplot(pca)

d <- dist(test, method = "euclidean")
fit <- hclust(d, method = "ave")
par(mfrow = c(1,2))
plot(fit, hang = -1)
rect.hclust(fit, k=6, border="red")