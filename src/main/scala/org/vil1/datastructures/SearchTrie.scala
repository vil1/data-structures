package org.vil1.datastructures

import collection.BitSet

/**
 * @author Valentin Kasas
 */
class SearchTrie(val root: SearchTrieNode[Any]) {
}

sealed trait SearchTrieNode[T] extends PartialFunction[T, SearchTrieNode[T]]{
  def read(input : Seq[T], output: BitSet): Unit = {
    this(input.head).read(input.tail, output)
  }
}

case class MapTrieNode[T](mapping : Map[T, SearchTrieNode[T]]) extends SearchTrieNode[T] {
  def isDefinedAt(x: T) = mapping.isDefinedAt(x)

  override def apply(in: T) = mapping(in)
}