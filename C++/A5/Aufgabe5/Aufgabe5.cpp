#include "pch.h"
#include <iostream>
#include <array>
#include <random>
#include <map>
#include <algorithm>
#include <string>

void increment(int &i)
{
	++i;
}

int main()
{
	std::random_device seed;
	std::mt19937 engine(seed());
	std::uniform_int_distribution<int> six(0, 9);
	std::map<std::string, int> buch;

	std::array<std::string, 10> words = { "Hei", "wie", "gehts", "Elefant", "T-Rex", "Regex", "Praktikum", "Schnee", "Publikum", "Festival" };

	for (int i = 0; i < 100; i++)
	{
		std::string randword = words[six(engine)];
		increment(buch[randword]);
		std::cout << (std::string)randword;
	}
	std::cout << std::endl;

	for (int i = 0; i < 10; i++)
	{
		std::cout << words[i] << ":\t\t" << buch[words[i]] << " mal enthalten" << std::endl;
	}
	std::cout << std::endl;
	for (std::map<std::string, int>::const_iterator i = buch.begin(); i != buch.end(); ++i)
	{
		std::cout << i->first << ":\t" << i->second << std::endl;
	}

	return 0;
}